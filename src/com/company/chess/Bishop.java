package com.company.chess;

import com.company.common.Coordinate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bishop extends Chessman {
    private Map<Coordinate, List<Coordinate>> steps = new HashMap<>();

    private List<Coordinate> cloneList(List<Coordinate> list) {
        return new ArrayList<>(list);
    }

    @Override
    protected void updateNextSteps() throws Exception {
        int x = this.getCoordinate().getX();
        int y = this.getCoordinate().getY();
//TH1: Quan tuong di cheo len ve ben phai
        int i1 = x, j1 = y;
        List<Coordinate> coordinates = new ArrayList<>();
        while (i1 < lastIndex && j1 > firstIndex) {
            i1++;
            j1--;

            Coordinate nextStep = new Coordinate(i1, j1);
            steps.put(nextStep, cloneList(coordinates));
            coordinates.add(nextStep);
        }
//TH2: Quan tuong di cheo xuong ve ben phai
        int i2 = x, j2 = y;
        coordinates.clear();
        while (i2 < lastIndex && j2 < lastIndex) {
            i2 ++;
            j2 ++;

            Coordinate nextStep = new Coordinate(i2, j2);
            steps.put(nextStep, cloneList(coordinates));
            coordinates.add(nextStep);
        }
//TH3: Quan tuong di cheo len ve phai trai
         int i3 = x, j3 = y;
        coordinates.clear();
        while (i3 > firstIndex && j3 > firstIndex) {
            i3--;
            j3--;

            Coordinate nextStep = new Coordinate(i3, j3);
            steps.put(nextStep, cloneList(coordinates));
            coordinates.add(nextStep);
        }
//TH4: Quan tuong di cheo xuong ve phia trai
         int i4 = x, j4 = y;
        coordinates.clear();
        while (i4 > firstIndex && j4 < lastIndex) {
            i4--;
            j4++;

            Coordinate nextStep = new Coordinate(i4, j4);
            steps.put(nextStep, cloneList(coordinates));
            coordinates.add(nextStep);
        }
    }

    @Override
    public Iterable<Coordinate> getNextSteps() {
        return this.steps.keySet();
    }

    @Override
    public Iterable<Coordinate> getPathTo(Coordinate destination) {
        return this.steps.get(destination);
    }

    @Override
    public char getName() {
        return 'T';
    }
}
