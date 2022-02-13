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
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 10/02/2022
 * Time: 08:36
 */
public class Repository {

    private static final String path = "src/com/certification/questions";
    private static final String template = "template.xml";

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

    public void createQuestion(CertificationVO vo) throws IOException {

        // Getting the template file object from directory
        File templateFile = new File(path + File.separator + template);
        try (Scanner scan = new Scanner(templateFile)) {
            StringBuilder buffer = new StringBuilder();
            while (scan.hasNextLine()) {
                buffer.append(scan.nextLine()).append(System.lineSeparator());
            }
            String fileContents = buffer.toString();

            // Filling question
            fileContents = fileContents.replaceAll("\\{\\{question\\}\\}", vo.getQuestion());

            // Filling explanation
            fileContents = fileContents.replaceAll("\\{\\{explanation\\}\\}", vo.getExplanation());

            // Extracting answer sub template
            String answerTemplate = null;
            String regex = "\\s+<answer[^s][^/]+/answer>";
            Pattern p = Pattern.compile(regex, Pattern.MULTILINE);
            Matcher m = p.matcher(fileContents);
            while (m.find()) {
                answerTemplate = m.group(0);
            }
            if (answerTemplate == null || answerTemplate.length() < 1) return;

            // Putting answers
            StringBuilder answersContents = new StringBuilder();
            for (int i =0; i< vo.getAnswers().size(); i++) {
                String answer = answerTemplate.replaceAll("\\{\\{id\\}\\}", Integer.toString(i+1));
                answer = answer.replaceAll("\\{\\{answer\\}\\}", vo.getAnswers().get(i));
                String rightOrWrong = "false";
                if (vo.getRightAnswers().contains(i+1)) {
                    rightOrWrong = "true";
                }
                answer = answer.replaceAll("\\{\\{rightOrWrong\\}\\}", rightOrWrong);
                answersContents.append(answer);
            }

            // Filling answers
            if (answersContents.length() > 0) {
                fileContents = fileContents.replaceAll(Pattern.quote(answerTemplate), answersContents.toString());
            }
//            System.out.println(fileContents);

            // Writing file down to disk
            FileWriter writer = new FileWriter(path + File.separator + UUID.randomUUID() + ".xml");
            writer.append(fileContents);
            writer.flush();
        }
    }

    public CertificationVO getQuestion() {

        int index;
        File file;
        do {
            index = new Random().nextInt(this.allQuestions.length);
            file = this.allQuestions[index];
        } while (file.getName().equals(template));

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
        File directoryPath = new File(path);
        //List of all files and directories
        allQuestions = directoryPath.listFiles();
    }

}
