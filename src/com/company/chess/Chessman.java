package com.company.chess;

import com.company.common.Coordinate;
import com.company.common.Game;

public abstract class Chessman {
    private Coordinate coordinate;
    protected final int firstIndex = Game.FIRST_INDEX;
    protected final int lastIndex = Game.LAST_INDEX;

    private boolean _coordinateIsNotEqualWith(Coordinate coordinate) {  //Tach ham de so sanh dieu kien ben duoi (lay cac nuoc di cua quan co)

        return this.coordinate == null || !this.coordinate.equals(coordinate);
    }

    protected abstract void updateNextSteps() throws Exception; //Lay cac nuoc di tiep theo co the di duoc


    public final void setCoordinate(Coordinate coordinate) throws Exception {
        if (_coordinateIsNotEqualWith(coordinate)) {
            this.coordinate = coordinate;
            this.updateNextSteps();
        }
    }

    public final Coordinate getCoordinate() {
        return coordinate;
    }

    public final boolean isValidNextCoordinate(Coordinate nextCoordinate) { //Xac dinh nuoc di co hop le hay khong?
        Iterable<Coordinate> coordinates = this.getNextSteps();
        for (Coordinate coordinate: coordinates) {
            if (coordinate.equals(nextCoordinate)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Get all next available steps (coordinates)
     * @return Iterable<Coordinate>
     */
    public abstract Iterable<Coordinate> getNextSteps();

    /**
     * Get all coordinates of the path to destination.
     * @param destination Coordinate
     * @return Iterable<Coordinate>
     */
    public abstract Iterable<Coordinate> getPathTo(Coordinate destination);

    public abstract char getName();
}
