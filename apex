var ig$ = apex.region("SLOWNIK").widget();
if (ig$) {
    var model = ig$.interactiveGrid("getViews", "grid").model;
    var recs = model.getRecords(); // pobierz wszystkie wiersze
    var segment = apex.item("P4_SEGMENT").getValue();
    var targetRec = null;

    // znajdź wiersz odpowiadający wybranemu segmentowi
    for (var i = 0; i < recs.length; i++) {
        if (model.getValue(recs[i], "SEGMENT") === segment) {
            targetRec = recs[i];
            break;
        }
    }

    if (targetRec) {
        var val = model.getValue(targetRec, "MAX_Z_SCORE");
        apex.item("P4_MAX_Z_SCORE").setValue(val);
    } else {
        console.warn("Nie znaleziono wartości domyślnej dla segmentu: " + segment);
    }
}
