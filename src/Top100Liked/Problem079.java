package Top100Liked;


public class Problem079 {

    boolean resultFlag=false;
    public boolean exist(char[][] board, String word) {
        int row=board.length;
        int col=board[0].length;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]==word.charAt(0)){
                    boolean[][] isVisited=new boolean[row][col];
                    isVisited[i][j]=true;
                    DFS(board,isVisited,word,1,i,j);
                    if(resultFlag==true){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void DFS(char[][] board,boolean[][] isVisited,String word,int index,int row,int col){
        if(index==word.length()){
            resultFlag=true;
            return;
        }
        if(row-1>=0 && board[row-1][col]==word.charAt(index) && isVisited[row-1][col]==false && resultFlag==false){
            isVisited[row-1][col]=true;
            DFS(board,isVisited,word,index+1,row-1,col);
            isVisited[row-1][col]=false;
        }
        if(row+1<=board.length-1 && board[row+1][col]==word.charAt(index) && isVisited[row+1][col]==false && resultFlag==false){
            isVisited[row+1][col]=true;
            DFS(board,isVisited,word,index+1,row+1,col);
            isVisited[row+1][col]=false;
        }
        if(col-1>=0 && board[row][col-1]==word.charAt(index) && isVisited[row][col-1]==false && resultFlag==false){
            isVisited[row][col-1]=true;
            DFS(board,isVisited,word,index+1,row,col-1);
            isVisited[row][col-1]=false;
        }
        if(col+1<=board[0].length-1 && board[row][col+1]==word.charAt(index) && isVisited[row][col+1]==false && resultFlag==false){
            isVisited[row][col+1]=true;
            DFS(board,isVisited,word,index+1,row,col+1);
            isVisited[row][col+1]=false;
        }
    }

    public static void main(String... args){
        Problem079 main = new Problem079();
        char[][] board = {{'A'}};
        System.out.println(main.exist(board,"A"));
    }
}
