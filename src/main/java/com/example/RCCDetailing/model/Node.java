package com.example.RCCDetailing.model;

public class Node {
    int nodeNumber;
    Coordinate coordinate;

    public Node(int nodeNumber, Coordinate coordinate) {
        this.nodeNumber = nodeNumber;
        this.coordinate = coordinate;
    }

    public Node(int nodeNumber, double x, double y, double z) {
        this.nodeNumber = nodeNumber;
        this.coordinate = new Coordinate(x,y,z);
    }

    public int getNodeNumber() {
        return nodeNumber;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }
}
