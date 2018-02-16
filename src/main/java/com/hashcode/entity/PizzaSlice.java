package com.hashcode.entity;

import java.util.List;
import java.util.Objects;

import static com.hashcode.entity.PizzaIngredient.MUSHROOM;
import static com.hashcode.entity.PizzaIngredient.TOMATO;

public class PizzaSlice {
    private int rowTop;
    private int rowBottom;
    private int colLeft;
    private int colRight;
    private List<PizzaCell> sliceCells;

    private PizzaSlice(int rowTop, int rowBottom, int colLeft, int colRight, List<PizzaCell> sliceCells) {
        this.rowTop = rowTop;
        this.rowBottom = rowBottom;
        this.colLeft = colLeft;
        this.colRight = colRight;
        this.sliceCells = sliceCells;
    }

    public PizzaSlice() {
    }

    public int getRowTop() {
        return rowTop;
    }

    public int getRowBottom() {
        return rowBottom;
    }

    public int getColLeft() {
        return colLeft;
    }

    public int getColRight() {
        return colRight;
    }

    public List<PizzaCell> getSliceCells() {
        return sliceCells;
    }

    public void setRowTop(int rowTop) {
        this.rowTop = rowTop;
    }

    public void setRowBottom(int rowBottom) {
        this.rowBottom = rowBottom;
    }

    public void setColLeft(int colLeft) {
        this.colLeft = colLeft;
    }

    public void setColRight(int colRight) {
        this.colRight = colRight;
    }

    public void setSliceCells(List<PizzaCell> sliceCells) {
        this.sliceCells = sliceCells;
    }

    public int getQuantityOfMinCountIngredient(PizzaIngredient ingredient){
        Objects.requireNonNull(sliceCells);
        Objects.requireNonNull(ingredient);

        int tomatoQuantity = 0;
        int mushroomQuantity = 0;

        for (PizzaCell cell: sliceCells) {
            if(cell.getIngredient().equals(TOMATO)){
                tomatoQuantity++;
            } else if(cell.getIngredient().equals(MUSHROOM)){
                mushroomQuantity++;
            }
        }
        if(ingredient.equals(TOMATO)){
            return tomatoQuantity;
        } else {
            return mushroomQuantity;
        }
    }

    public static class Builder {
        private int rowTop;
        private int rowBottom;
        private int colLeft;
        private int colRight;
        private List<PizzaCell> sliceCells;

        public Builder setRowTop(int rowTop) {
            this.rowTop = rowTop;
            return this;
        }

        public Builder setRowBottom(int rowBottom) {
            this.rowBottom = rowBottom;
            return this;
        }

        public Builder setColLeft(int colLeft) {
            this.colLeft = colLeft;
            return this;
        }

        public Builder setColRight(int colRight) {
            this.colRight = colRight;
            return this;
        }

        public Builder setSliceCells(List<PizzaCell> sliceCells) {
            this.sliceCells = sliceCells;
            return this;
        }

        public PizzaSlice build() {
            return new PizzaSlice(rowTop, rowBottom, colLeft, colRight, sliceCells);
        }
    }
}
