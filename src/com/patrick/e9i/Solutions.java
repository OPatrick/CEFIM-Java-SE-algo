package com.patrick.e9i;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 03/02/2022
 * Time: 08:59
 */
public final class Solutions {

    private int countRecursive;
    private int countIterations;
    private int depth = 0;
    private double duration;
    ArrayList<int[]> liste = new ArrayList<>();

    public int getRecursiveCount() {
        return countRecursive;
    }

    public void addRecursiveTic() {
        this.countRecursive++;
    }

    public int getIterationCount() {
        return countIterations;
    }

    public void addIterationTic() {
        this.countIterations++;
    }

    public double getDuration() {
        return this.duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public void addSolution(int @NotNull [] solution) {
        // a + 13 * b / c  + d + 12 * e - f -11 + g * h / i -10 = 66
        float result = -21 + solution[0] + 13*solution[1]/((float)solution[2]) + solution[3] + 12*solution[4] - solution[5] + solution[6]  *solution[7]  / ((float)solution[8]);
        if (66f ==  result) {
            liste.add(solution);
        }
    }

    public void reset() {
        this.liste = new ArrayList<>();
        resetCounters();
    }

    public void resetCounters() {
        this.depth = 0;
        this.countIterations = 0;
        this.countRecursive = 0;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        if (liste.size() > 0) {
            str.append(liste.size());
            str.append(" solutions | ");
            str.append("1ère trouvée : ");
            str.append(Arrays.toString(liste.get(0)));
        } else {
            str.append("Aucune solution trouvée");
        }
        str.append(" | Itérations : ");
        str.append(String.format("%" + (-6) + "s", this.getIterationCount()));
        str.append(" | Récursivités : ");
        str.append(String.format("%" + (-6) + "s", this.getRecursiveCount()));
        str.append(" | Niveaux de récursivité : ");
        str.append(String.format("%" + (-2) + "s", this.getDepth()));
        str.append(" | Durée : ");
        str.append(Math.round(this.getDuration()));
        str.append(" ms");
        return str.toString();
    }
}
