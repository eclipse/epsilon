rule Tree2Tree 
    match l : T1!Tree 
    with r : T2!Tree in {return T2!Tree.all.select(a|a.label="a");} {

    compare : l.label.println() = r.label and 
        l.parent.matches(r.parent) and
        l.children.matches(r.children)
}