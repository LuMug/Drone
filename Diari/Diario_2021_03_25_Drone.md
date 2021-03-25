# Drone | Diario di lavoro
##### Michea Colautti, Alessandro Aloise, Gianni Grasso, Samuele Ganci
### Centro Professionale Trevano, 25.03.2021

## Lavori svolti


|Orario        |Lavoro svolto                                                        |Eseguito da                 |
|--------------|---------------------------------------------------------------------|----------------------------|
|08:20 - 09:00 | Riunione generale                                                   |Tutti                       |
|09:00 - 09:35 | Gantt consuntivo	                                                    |Samuele                     |
|09:00 - 10:05 | Sviluppo connessione tra comandi e ImageFrame (Metodo 1)            |Michea                      |
|09:00 - 10:05 | Comprensione e ripresa codice per la live                           |Gianni                      |
|09:00 - 14:15 | Sviluppo sito applicativo                                           |Alessandro                  |
|09:35 - 09:50 | Finitura dei comandi con le dita + calibrazione per le rotazioni    |Samuele                     |
|10:05 - 11:35 | Implementazione registrazione comandi                               |Samuele                     |
|10:05 - 11:35 | Sviluppo e correzione della live                                    |Gianni e Michea             |
|12:30 - 13:40 | Implementata ri-esecuzione vecchie sequenze di comandi registrati   |Samuele                     |
|12:30 - 13:40 | Ripresa collegamento ImageFrame a Drone                             |Michea                      |
|12:30 - 13:40 | Sviluppo codice per la live                                         |Gianni                      |
|13:40 - 14:15 | Consultazione con il gruppo                                         |Tutti                       |
|14:15 - 14:30 | Riunione gruppo e con professore                                    |Tutti                       |
|14:30 - 15:45 | Sviluppo sito applicativo                                           |Alessandro                  |
|14:30 - 15:45 | Sviluppo codice per la live                                         |Gianni                      |
|14:30 - 14:50 | Collegamento con ImageFrame                                         |Michea e Samuele            |
|14:50 - 15:00 | Implementazione pulsante e editText e sequenza di comandi           |Samuele                     |
|15:00 - 15:45 | Fix del progetto e merge tra i 2 codici sviluppati                  |Samuele e Michea            |


## Problemi riscontrati e soluzioni adottate

1. Quest'oggi Alessandro non ha potuto essere presente con noi in classe, per questo abbiamo dovuto connetterci con lui in chiamata vocale,
interagendo quando era necessario.
2. Mentre sviluppavamo la logica per l'ottenimento dei valori del drone (`pitch`,`yaw`,`roll`, ecc.) ci siamo imbattuti in un problema. Il metodo che avevamo creato ritornava dei valori sbagliati, nello specifico delle `String`, quando avrebbe dovuto ritornare `int`. Abbiamo indagato e scoperto che in realtà venivano ritornate delle stringhe vuote. Il metodo veniva invocato prima che i dati venissero collezionati. Questo ci ha spinti a cambiare strategia.
3. Abbiamo avuto una discussione su come gestire le sequenze, se utilizzare un file di testo oppure il `DB` già preparato. Abbiamo concluso che avremmo iniziato creando i file di testo, per poi passare all'utilizzo del `DB` quando necessario.
4. Mentre cercavamo un template per il sito, abbiamo dovuto prendere una decisione: utilizzare un sito molto bello, ma che sarebbe rimasto hostato su dei server esterni (senza la possibilità di download quindi), oppure se utilizzare un template di livello inferiore, ma che si potesse scaricare. Abbiamo optato per la seconda opzione, in quanto desideravamo avere l'applicativo pubblicato sui nostri siti personali.
5. Per lo sviluppo della live abbiamo incontrato molte difficoltà. Non siamo riusciti ad utilizzare appieno il codice già scritto, abbiamo dovuto apportare modifiche che per ora non ci hanno ancora portato ad una soluzione valida.
6. Nel secondo tentavi del collegamento tra ImageFrame e il codice del drone abbiamo deciso di prelevare i dati dal drone direttamente dalla classe che invia i messaggi al drone. Creando un’istanza di tipo `ImageFrame` è stato infatti possibile creare un metodo per inviare il comando `rc`. Tuttavia una volta aggiornati i metodi in `ImageFrame` le 2 immagini (frontale e laterale) risultavano invisibili.
7. Sopra abbiamo parlato di sole 2 immagini. Questo perché per quanto riguarda l'altitudine e la posizione (imbardata) dobbiamo prelevare i dati dal drone, in quanto quelli inviati non vanno bene (sono solo i dati elaborati di quanto si è mossa la mano, che non corrispondono a quello che vogliamo noi).
8. Abbiamo incontrato difficoltà nel fare il `merge` finale dei codici. Per questo abbiamo dovuto procedere con cautela e salvare i file a poco a poco, facendo anche alcuni copia-incolla per ripristinare del codice che ci potrebbe tornare utile.

Ecco quindi le soluzioni riassunte:
>1. Collegamento video.
>2. Nuovo approccio di ottenimento dati.
>3. Utilizzo temporaneo di file di testo.
>4. Utilizzo template sito scaricabile.
>6. Consultazione di gruppo e riferimenti tra `ImageFrame` e `Drone`.
>7. `Merge` passo. 



## Punto della situazione rispetto alla pianificazione
Oggi, anche a causa dell'assenza di uno di noi, non siamo andati avanti come la scorsa volta. Tuttavia abbiamo comunque fatto un buon lavoro e preparato una base su cui lavorare la prossima volta.

## Programma di massima per la prossima giornata di lavoro
1. Completare collegamento tra `ImageFrame` e `Drone`.
2. Andare avanti (o completare) live.
3. Utilizzare il `DB` per immagazzinare i dati di volo.
4. Creazione panel statistiche.

