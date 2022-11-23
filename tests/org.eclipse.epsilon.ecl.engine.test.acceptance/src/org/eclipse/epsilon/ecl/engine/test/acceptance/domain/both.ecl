rule Tree2Tree 
    match l : T1!Tree in: T1!Tree.all.select(a|a.label="a")
    with r : T2!Tree in: T2!Tree.all.select(a|a.label="a") {

    compare : l.label = r.label and 
        l.parent.matches(r.parent) and
        l.children.matches(r.children)
}