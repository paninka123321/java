// Poczekaj aż IG będzie gotowy
apex.region("SLOWNIK").widget().interactiveGrid("getViews", "grid").model.promise().then(function(model) {
    var recs = model.getRecords();
    var segment = apex.item("P4_SEGMENT").getValue();
    var targetRec = null;

    for (var i = 0; i < recs.length; i++) {
        if (model.getValue(recs[i], "SEGMENT") === segment) {
            targetRec = recs[i];
            break;
        }
    }

    if (targetRec) {
        apex.item("P4_MAX_Z_SCORE").setValue(model.getValue(targetRec, "MAX_Z_SCORE"));
        apex.item("P4_MAX_DIFF").setValue(model.getValue(targetRec, "MAX_DIFF"));
    }
});
