package com.smolus.labyrinth.Maze;

import java.util.ArrayList;

/**
 * Created by SMOLUS on 2017-01-19.
 */

public class Generator {

    private int size;
    public int[] board;
    private int current = 0;
    private ArrayList<Integer> neighbors = new ArrayList<Integer>();
    private ArrayList<Integer> road = new ArrayList<Integer>();
    private ArrayList<Integer> story = new ArrayList<Integer>();

    public Generator(int size){
        this.size = size;
        board = new int[size*size];
        for(int i = 0; i<size;i++){
            for(int j = 0; j<size;j++){
                board[index(i,j)] = 1;
            }
        }
        while(true){
            board[current] = 0;
            checkNeighbors();
            if(neighbors.size() > 0){
                int rand = (int)(Math.random() * neighbors.size());
                current = neighbors.get(rand);
                board[road.get(rand)] = 0;
                story.add(current);
                road.clear();
                neighbors.clear();
            }else if(story.size() > 1){
                story.remove(story.size() - 1);
                current = story.get(story.size() - 1);
            }else{
                break;
            }
        }
    }

    private void checkNeighbors(){
        if((current + 1)%size != 0 && board[current+2] == 1){
            neighbors.add(current+2);
            road.add(current + 1);
        }
        if((current + size*2) <= size*size && board[current + size*2] == 1){
            neighbors.add(current + size*2);
            road.add(current + size);
        }
        if((current)%size != 0 && board[current-2] == 1){
            neighbors.add(current-2);
            road.add(current-1);
        }
        if((current - size*2) >= 0 && board[current - size*2] == 1){
            neighbors.add(current - size*2);
            road.add(current - size);
        }
    }


    private int index(int x, int y){
        return x + y*size;
    }
}
