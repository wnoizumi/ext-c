package nz.ac.vuw.ecs.kcassell.cluster;

/* 
 * This code came from JUng 1.7 but wasn't ported to 2.0
 * jung/src/edu/uci/ics/jung/algorithms/cluster/ExactFlowCommunity.java
 * from http://www.google.com/codesearch?hl=en&lr=&q=exactflowcommunity+lang%3Ajava&sbtn=Search
 */

/*
 * Copyright (c) 2003, the JUNG Project and the Regents of the University
 * of California
 * All rights reserved.
 *
 * This software is open-source under the BSD license; see either
 * "license.txt" or
 * http://jung.sourceforge.net/license.txt for a description.
 */

/**
 * ExactFlowCommunity is an algorithm that uses a set of root nodes that are
 * supposed to be representative of a community to find the entire community
 * using principles based on max-flow/min-cut.
 * @author Scott White
 * @see "Self-Organization of the Web and Identification of Communities by Gary
 * Flake, Steve Lawrence, Lee Giles, and Frans Coetzee, 2002"
 * @see "http://www.neci.nec.com/~lawrence/papers/web-computer02/web-computer02.pdf"
 */
public class FlakeGraphClusterer {
    private int mCohesionThreshold;

    /**
     * Constructs and initializes the algorithm
     * @param cohesionThreshold a heuristic value that determines the
     * level of cohesion for the community to be extracted
     */
    public FlakeGraphClusterer(int cohesionThreshold) {
        mCohesionThreshold = cohesionThreshold;
    }

    /**
     * Extracts the community according to the cohesion threshold
     * @param graph the original graph
     * @param rootSet the set of nodes used to see the community
     * @return a set of nodes representative of the community used to seed the algorithm
     */
//    public Set extract(//DirectedGraph graph
//    		JavaCallGraph callGraph, Set rootSet) {
//    	Graph<CallGraphNode,CallGraphLink> jungGraph = callGraph.getJungGraph();
//        DirectedGraph flowGraph = (DirectedGraph) graph.copy();
//        CallGraphNode source = flowGraph.addVertex(new SparseVertex());
//        CallGraphNode sink = flowGraph.addVertex(new SparseVertex());
//
//        initializeFlowGraph(flowGraph,source, sink,rootSet);
//        EdmondsKarpMaxFlow maxFlowSolver = new EdmondsKarpMaxFlow(flowGraph,source,sink,"CAPACITY","FLOW");
//        maxFlowSolver.evaluate();
//        Set sourceNodes = maxFlowSolver.getNodesInSourcePartition();
//        for (Iterator vIt = sourceNodes.iterator();vIt.hasNext();) {
//            CallGraphNode v = (CallGraphNode) vIt.next();
//            if (v.getEqualVertex(flowGraph) != source) {
//                communityVertices.add(v.getEqualVertex(graph));
//            }
//        }
//
//        return communityVertices;
//    }
//
//    /**
//     * Implements the "ApproximateFlowCommunity" algorithm. Repeatedly
//     * finds the community at low distances from the starting set, and
//     * grows outward. UNDERTESTED.
//     * @param graph the original graph
//     * @param rootSet the set of nodes used to see the community
//     * @return a set of nodes representative of the community used to seed the algorithm
//     */
//    public static Set extract(DirectedGraph graph, Set rootSet, int numIterations) {
//        Set members = new HashSet(rootSet);
//        Set newMembers = null;
//        int numPreviousMembers = members.size();
//        int numCurrentMembers = 0;
//
//        for (int i=0;i<numIterations;i++) {
//            FlakeGraphClusterer ecf = new FlakeGraphClusterer(members.size());
//            newMembers = ecf.extract(graph,members);
//            numCurrentMembers = newMembers.size();
//            if (numPreviousMembers == numCurrentMembers) {
//                break;
//            }
//            numPreviousMembers = numCurrentMembers;
//            System.out.println(members.size());
//            DoubleArrayList inDegrees = DegreeDistributions.getIndegreeValues(newMembers);
//            int maxIndegree = (int) Descriptive.max(inDegrees);
//            DoubleArrayList outDegrees = DegreeDistributions.getOutdegreeValues(newMembers);
//            int maxOutdegree = (int) Descriptive.max(outDegrees);
//
//            for (Iterator vIt = newMembers.iterator(); vIt.hasNext();) {
//                CallGraphNode v = (CallGraphNode) vIt.next();
//                if (members.contains(v)) {
//                    continue;
//                }
//                if (v.inDegree() == maxIndegree) {
//                    members.add(v);
//                } else if (v.outDegree() == maxOutdegree) {
//                    members.add(v);
//                }
//            }
//        }
//
//        return newMembers;
//
//    }
//
//    /**
//     * Initialize the flow graph
//     * @param flowGraph the flow graph
//     * @param source the source node
//     * @param sink the sink node
//     * @param rootSet the set of nodes used to seed the community
//     */
//    protected void initializeFlowGraph(DirectedGraph flowGraph,CallGraphNode source, CallGraphNode sink,Set rootSet) {
//
//        NumericDecorator capacityDecorator = new NumericDecorator("CAPACITY",UserData.SHARED);
//
//        List edgesList = new ArrayList();
//        edgesList.addAll(flowGraph.getEdges());
//
//        for (int idx = 0; idx < edgesList.size(); idx++) {
//            DirectedEdge currentEdge = (DirectedEdge) edgesList.get(idx);
//            capacityDecorator.setValue(new MutableInteger(mCohesionThreshold),currentEdge);
//
//            // finds edges that aren't reciprocated
//            // that is, this is an edge from (A to B). This looks for the edge that runs from B to A.
//            Edge otherEdge = currentEdge.getDest().findEdge(currentEdge.getSource());
//            if (otherEdge == null) {
//                otherEdge = GraphUtils.addEdge(flowGraph,currentEdge.getDest(),currentEdge.getSource());
//                capacityDecorator.setValue(new MutableInteger(mCohesionThreshold),otherEdge);
//            }
//        }
//
//        for (Iterator vIt = flowGraph.getVertices().iterator(); vIt.hasNext();) {
//            CallGraphNode currentVertex = (CallGraphNode) vIt.next();
//            if (currentVertex != sink && !rootSet.contains(currentVertex)) {
//                Edge newEdge = GraphUtils.addEdge(flowGraph,currentVertex,sink);
//                capacityDecorator.setValue(new MutableInteger(1),newEdge);
//            }
//        }
//
//        for (Iterator rootIt = rootSet.iterator(); rootIt.hasNext();) {
//            CallGraphNode currentRoot = (CallGraphNode) rootIt.next();
//            currentRoot = (CallGraphNode) currentRoot.getEqualVertex(flowGraph);
//            Edge e= GraphUtils.addEdge(flowGraph,source,currentRoot);
//            capacityDecorator.setValue(new MutableInteger(Integer.MAX_VALUE),e);
//        }
//    }
}
