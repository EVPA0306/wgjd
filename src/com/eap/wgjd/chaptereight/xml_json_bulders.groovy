//def writer = new StringWriter();
//def xml = new groovy.xml.MarkupBuilder(writer);
def json = new groovy.json.JsonBuilder();
json.person(id:2) {
    name "Eugene"
    age 43
    address (
        city:"Englewood"
        , zip:80111
    )
}
println json.toString()