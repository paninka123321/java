// Pobierz referencję do Interactive Grid
var ig$ = apex.region("SLOWNIK").widget();

// Sprawdź, czy IG jest dostępny
if (ig$) {
    var model = ig$.interactiveGrid("getViews", "grid").model;

    // Pobierz pierwszy wiersz (zakładam, że masz tylko jeden z wartościami domyślnymi)
    var rec = model.getRecord(model.getRecordIds()[0]);

    if (rec) {
        // Pobierz wartości kolumn
        var maxZScore = model.getValue(rec, "MAX_Z_SCORE");
        var maxDiff   = model.getValue(rec, "MAX_DIFF");

        // Ustaw wartości w filtrach (elementy strony)
        apex.item("P4_MAX_Z_SCORE").setValue(maxZScore);
        apex.item("P4_MAX_DIFF").setValue(maxDiff);

        // (Opcjonalnie) — automatycznie odśwież wykres/tabelę po ustawieniu
        // apex.region("TABELA").refresh();
        // apex.region("WYKRES").refresh();
    } else {
        console.warn("Nie znaleziono żadnych rekordów w regionie SŁOWNIK.");
    }
} else {
    console.error("Nie znaleziono regionu SŁOWNIK — sprawdź Static ID.");
}
