import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
      
      Node[] arr = new Node[numCourses];
      for (int i = 0; i<numCourses; i++){
          Node n = new Node(i);
          arr[i] = n;
      }
      
      for (int[] prerq: prerequisites){
          int mainCourse = prerq[0];
          int dependency = prerq[1];
          
          Node mainCourseNode = arr[mainCourse];
          mainCourseNode.req += 1; 
          
          Node dependencyNode = arr[dependency];
          dependencyNode.dependents.add(mainCourseNode); 
      }
      
      Queue<Node> pq = new
           LinkedList<Node>();
      
      for (Node n: arr){
          if (n.req == 0 ){
              pq.add(n);    
          }
      }
      
      int[] ans = new int[numCourses];
      int ind = 0;
      
      while(pq.size()>0){
          // remove the node with 0 pre-req;
          Node toTake = pq.remove();
          
          ans[ind] = toTake.course; // taking this course now
          
          for (Node d : toTake.dependents){
              d.req -= 1;
              if (d.req == 0){
                  pq.add(d);
              }
          }
          ind++;
            
      }
      
      if (ind<numCourses){
          return new int[0];
      }
      return ans;
  }
}

class Node{
  int course;
  int req;
  ArrayList<Node> dependents = new ArrayList<Node>();
  
  public Node(int c){
      this.course = c;
  }
}