package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import java.util.Arrays;

public class Percolation {
  // create N-by-N grid, with all sites initially blocked
  private boolean [][] world;
  private int openSitesSize;
  private WeightedQuickUnionUF uf;
  private int topIndex;
  private int bottomIndex;


  public Percolation(int N){
    this.world = new boolean[N][N];
    this.openSitesSize=0;
    int firstRowIndex;
    int lastRowIndex;
    this.uf = new WeightedQuickUnionUF(N*N+2);
    this.topIndex = N*N;
    this.bottomIndex = N*N+1;

    // for(int i=0; i<world[N-1].length; i++){
    //   lastRowIndex = xyTo1D(N-1,i);
    //   uf.union(bottomIndex,lastRowIndex);
    //   // System.out.println("lastRowIndex: "+lastRowIndex+ ", Root: "+uf.find(lastRowIndex));
    // }

    for(boolean[] array:world){
      Arrays.fill(array,false);
    }
  }

  // open the site (row, col) if it is not open already
  public void open(int row, int col){
    validateIndex(row,col);
    if(!world[row][col]){
      if(row==0){
        int index = xyTo1D(row,col);
        uf.union(topIndex,index);
      }
      world[row][col]=true;
      unionNeighbors(row,col);
      openSitesSize++;
    }
  }

  // is the site (row, col) open?
  public boolean isOpen(int row, int col){
    validateIndex(row,col);
    return world[row][col];
  }

   // is the site (row, col) full?
  public boolean isFull(int row, int col){
    validateIndex(row,col);
    int indexA = xyTo1D(row,col);
    return uf.connected(indexA,topIndex);
  }

  // number of open sites
  public int numberOfOpenSites(){
    return openSitesSize;
  }

  // does the system percolate?
  //TODO
  public boolean percolates(){
    return false;
  }

  public void printWorld(){
    for(boolean[] arr:world){
      for(boolean value:arr){
        System.out.print(value+",");
      }
      System.out.println();
    }
  }

  //convert 2D index to 1D index
  private int xyTo1D(int r, int c){
    return r*world.length+c;
  }

  private void unionNeighbors(int r, int c){
    int indexA = xyTo1D(r,c);
    int indexB;
    //Top
    if(r-1>=0 && world[r-1][c]){
      // System.out.println("Top");
      indexB = xyTo1D(r-1,c);
      if(!uf.connected(indexA,indexB)){
        uf.union(indexA,indexB);
      }
    }
    //bottom
    if(r+1<=world.length-1 && world[r+1][c]){
      // System.out.println("Bottom");
      indexB = xyTo1D(r+1,c);
      if(!uf.connected(indexA,indexB)){
        uf.union(indexA,indexB);
      }
    }
    //left
    if(c-1>=0 && world[r][c-1]){
      indexB = xyTo1D(r,c-1);
      if(!uf.connected(indexA,indexB)){
        uf.union(indexA,indexB);
      }
    }
    //right
    if(c+1<=world.length-1 && world[r][c+1]){
      // System.out.println("Right");
      indexB = xyTo1D(r,c+1);
      if(!uf.connected(indexA,indexB)){
        uf.union(indexA,indexB);
      }
    }
  }

  private void validateIndex(int row, int col){
    if(row<0||row>world.length-1||col<0||col>world.length-1)
      throw new IndexOutOfBoundsException();
  }

  // use for unit testing (not required, but keep this here for the autograder)
  public static void main(String[] args){
    Percolation p = new Percolation(3);
    p.open(2,2);
    p.open(1,0);
    p.open(2,1);
    p.open(0,2);
    p.open(0,1);
    p.open(0,0);
    p.open(2,0);
    p.open(1,2);
    p.printWorld();
    System.out.println(p.numberOfOpenSites());

  }
}
