rule Flowcharts 
	match l : Left!Flowchart
	with r : Right!Flowchart {
	compare : true
}

@greedy
rule Node 
	match l : Left!Node
	with r : Right!Node {
	compare : l.name = r.name
}

rule Transitions 
	match l : Left!Transition
	with r : Right!Transition {
	compare : l.name = r.name and 
		l.source.matches(r.source) and 
		l.target.matches(r.target)
}