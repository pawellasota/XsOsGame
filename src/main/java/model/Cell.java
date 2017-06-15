package model;


import type.Seed;

public class Cell {

    Seed content;

    public Cell() {
        clear();
    }

    public Seed getContent() {
        return content;
    }

    public void setContent(Seed content) throws NullPointerException {
        if (content == null) {
            throw new NullPointerException();
        }
        this.content = content;
    }

    public void clear() {
        content = Seed.EMPTY;
    }
}
