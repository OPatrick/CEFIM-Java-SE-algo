package com.certification.trainer;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 10/02/2022
 * Time: 08:36
 */
public class Repository {

    File[] allQuestions;
    File[] usedQuestions;
    DocumentBuilder db;

    public Repository(int numberOfQuestions) {
        getQuestionsList();
        this.usedQuestions = new File[numberOfQuestions];

        try {
            // Instantiate the Factory
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

            // optional, but recommended
            // process XML securely, avoid attacks like XML External Entities (XXE)
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            // parse XML file
            db = dbf.newDocumentBuilder();

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public CertificationVO getQuestion() {

        int index;
        File file;
        do {
            index = new Random().nextInt(this.allQuestions.length);
            file = this.allQuestions[index];
        } while (file.getName().equals("template.xml"));

        String question = "";
        String explanation = "";
        String[] answers = new String[0] ;
        List<Integer> rightAnswers = new ArrayList<>();

        try {
             Document doc = db.parse(file);

            // optional, but recommended
            // http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            // get <question>
            question = doc.getElementsByTagName("question").item(0).getTextContent();

            // get <answer>
            NodeList list = doc.getElementsByTagName("answer");
            answers = new String[list.getLength()];

            for (int temp = 0; temp < list.getLength(); temp++) {
                Node node = list.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    // get question's attribute
                    int i= Integer.parseInt(element.getAttribute("id"));
                    // get question's attribute right
                    if (element.getAttribute("right").equalsIgnoreCase("true")) {
                        rightAnswers.add(i);
                    }
                    // get text
                    answers[--i] = element.getTextContent();
                }
            }

            // get <explanation>
            explanation = doc.getElementsByTagName("explanation").item(0).getTextContent();

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }

        return new CertificationVO.VoBuilder()
                .setPath(file.getAbsolutePath())
                .setQuestion(question)
                .setAnswers(answers)
                .setRightAnswers(rightAnswers)
                .setExplanation(explanation)
                .build();
    }

    public void getQuestionsList() {
        //Creating a File object for directory
        File directoryPath = new File("src/com/certification/questions");
        //List of all files and directories
        allQuestions = directoryPath.listFiles();
    }

}
