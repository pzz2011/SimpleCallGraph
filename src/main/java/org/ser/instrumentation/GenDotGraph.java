package org.ser.instrumentation;

//import org.enoir.graphvizapi.*;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.io.File;
import java.io.FileOutputStream;

//import org.ser.instrumentation.*;


public class GenDotGraph {


    public static int writeGraphToFile(byte[] img, File to){
        try { 
            FileOutputStream fos = new FileOutputStream(to);
            fos.write(img);
            fos.close();
            System.out.println(">>>>>>>>");
        } catch (java.io.IOException ioe) { System.out.println("<<<<<<");return -1; }
 //       System.out.println("nmba");
        return 1;
    } 

    public static void GenGraph(String rootsignature) { 
        Graphviz gv = new Graphviz();
        Graph graph = new Graph("result", GraphType.DIGRAPH);

        HashMap<Integer, String>  rtable = storage.getNegativeTable();
        HashMap<String, Integer> table = storage.getPositiveTable(); 

        System.out.println("+++++++" + rootsignature);
  	//String rootsignature = "uk.co.halfninja.randomnames.CompositeNameGenerator.withGenerator";    
        int count = storage.getcount();	    
        Queue<Integer> q = new LinkedList<Integer>();
	    int rootindex = storage.getindex(rootsignature);
	Queue<Node> nq = new LinkedList<Node>();
        q.add(rootindex);
	Node from = new Node("" + rootindex);
	graph.addNode(from);
	String fname = "\"" + rtable.get(rootindex) +"\"";
	from.addAttribute(new Attribute("label", fname));
	nq.add(from);

	System.out.println(count);
	
        while( !q.isEmpty() ) { 
            int cur = q.poll();
            Node curn = nq.poll();
            for (int i = 0; i < count; ++i) { 
                if (storage.adj_ij(cur, i) != 0) { 
                    Node to = new Node("" + i);
//                    String tname = "\"" + rtable.get(i) + "\"";
//
		    String tname = "\"" + rtable.get(i) + " " + storage.adj_ij(cur, i) + " " + storage.time_ij(cur, i) + "ns" + "\"";
//
                    to.addAttribute(new Attribute("label",tname));
		    graph.addNode(to);		
                    graph.addEdge(new Edge("", curn, to));
                    q.add(i);
		    nq.add(to);
                }
            }	
        }

/*        Node n1 = new Node("N1");
        String s = "Node1.d";
        String ss = "\"" + s + "\"";
        n1.addAttribute(new Attribute("label", ss));
        Node n2 = new Node("N2");
        Node n3 = new Node("N3");

        graph.addNode(n1);
        graph.addNode(n2);
        graph.addNode(n3);
	Edge t = new Edge("5885", n1, n2);
	t.addAttribute(new Attribute("label", "23333"));
        graph.addEdge(new Edge("5885", n1, n2));
        graph.addEdge(new Edge("", n2, n3));
        graph.addEdge(new Edge("",n3,n1));*/



        String type = "png";
	String tmpPath = "/tmp";
        File out = new File("/home/zhenzhong/downloads/learnboost/premain/build/instrumentation/mytest/"+"/result."+ type);
        writeGraphToFile( gv.getGraphByteArray(graph, type, "100"), out );	

///////////////////////////////////////////////////////////////////////////////////////////////////////

	System.out.println("----------------------Y-------");
	System.out.println(table.get("uk.co.halfninja.randomnames.CompositeNameGenerator.withGenerator"));
	System.out.println(table.get("uk.co.halfninja.randomnames.CompositeNameGenerator$Entry.<init>"));
	System.out.println(table.get("uk.co.halfninja.randomnames.CompositeNameGenerator.<init>"));

	System.out.println(rtable.get(0));
	System.out.println(rtable.get(1));
	System.out.println(rtable.get(2));
	System.out.println(rtable.get(3));

	System.out.println(storage.adj_ij(0,1));
	System.out.println(storage.adj_ij(0,2));

////        String type = "png";
////	String tmpPath = "/tmp";
///        File out = new File(tmpPath+"/test."+ type);
////        writeGraphToFile( gv.getGraphByteArray(graph, type, "100"), out );

//	    return ;
    }  
 
}
