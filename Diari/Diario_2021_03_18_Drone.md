# Drone | Diario di lavoro
##### Michea Colautti, Alessandro Aloise, Gianni Grasso, Samuele Ganci
### Centro Professionale Trevano, 18.03.2021

## Lavori svolti


|Orario        |Lavoro svolto                                                        |Eseguito da                 |
|--------------|---------------------------------------------------------------------|----------------------------|
|08:20 - 08:30 | Riunione mattutina		                                             |Tutti (no Michea)           |
|08:30 - 09:05 | Rivisitazione Gantt e documentazione                                |Samuele                     |
|08:30 - 09:50 | Scrittura classe di log con metodo 1                                |Alessandro                  |
|08:30 - 09:50 | Sviluppo logica di guida con tastiera                               |Gianni                      |
|09:05 - 09:50 | Creazione Use Case e inserimento nella documentazione               |Samuele                     |
|10:05 - 11:35 | Ricerca e test per sostituzione istruzione go con rc                |Samuele                     |
|10:05 - 11:35 | Scrittura classe di log con metodo 2 + test su suddetta classe      |Alessandro                  |
|10:05 - 11:35 | Assieme a Samuele, test per sostituzione go con rc                  |Gianni                      |
|10:05 - 10:15 | Aggiornamento su situazione                                         |Michea                      |
|10:15 - 11:35 | Implementazione di ImageFrame                                       |Michea                      |
|12:30 - 13:45 | Implementazione movimenti asse x con rc                             |Samuele                     |
|12:30 - 13:15 | Creazione e modifiche panel per dato batteria                       |Alessandro                  |
|12:30 - 13:15 | Ripresa controllo drone con tastiera                                |Gianni                      |
|12:30 - 14:00 | Conclusa implementazione di ImageFrame + test                       |Michea                      |
|13:15 - 14:45 | Pulizia del codice e trasferitemi codice da BottoniFrame            |Alessandro e Gianni         |
|14:00 - 14:45 | Collegamento ImageFrame a Status                                    |Michea                      |
|13:45 - 14:30 | Implementazione movimenti asse y con rc                             |Samuele                     |
|14:30 - 15:15 | Implementazione movimenti con 2 mani contemporaneamente             |Samuele                     |
|14:45 - 15:15 | Creazione packages e fix errori                                     |Alessandro e Michea         |
|14:45 - 15:15 | Assieme a Samuele, implementazione movimenti in Leap Motion         |Gianni                      |
|15:15 - 15:45 | Test su movimenti drone e consultazione su prossimo passo           |Tutti                       |

## Problemi riscontrati e soluzioni adottate


1. Come concordato nella scorsa lezione, ci siamo occupati di realizzare una classe di log: questa classe ci avrebbe permesso di pulire il codice e ottener informazioni importanti per il nostro progetto. Tuttavia dopo una iniziale scrittura della classe, e dopo un avviso dal docente, abbiamo dovuto modificare la classe nuovamente. Abbiamo dovuto infatti dovuto utilizzare la classe `Logger`, una delle tante classi integrate in Java.
2. Durante lo sviluppo dello `Use Case` ci siamo accorti che stava venendo fin troppo semplicistico: infatti si componeva di pochissime relazioni. Per questo abbiamo dovuto rendere lo `Use Case` più specifico, includendo anche i procedimenti interni al nostro programma.
3. Mentre cercavamo di includere l'istruzione `rc` anche per il `Leap Motion`, abbiamo incontrato difficoltà nella gestione del volo. Per questo abbiamo dovuto fare alcune ricerche.
4. Mentre implementavamo `ImageFrame` nel resto del programma abbiamo ottenuto alcuni errori di "compatibilità". Abbiamo dovuto infatti modificare anche la classe `FunzioniPanel`, per permettere al frame con le immagini, `ImageFrame` appunto, di apparire al momento giusto. Abbiamo dovuto anche modificare leggermente quest'ultima classe per evitare che alla sua chiusura, tutto il programma venisse fermato.
5. Nel pomeriggio ci siamo accorti di un problema che da troppo evitavamo. Il nostro codice, e il nostro progetto in generale, era piuttosto disordinato e in alcuni punti "sporco". Per questo abbiamo dovuto iniziare a spostare il codice da `BottoniPanel` a `Drone`. La prima di queste due classi è nata infatti come base per condurre dei test, ed ora che siamo in un punto piuttosto avanzato del progetto era ora di rendere il codice da noi scritto più "definitivo". Abbiamo anche dovuto creare dei `package` separati. Un particolare errore si è presentato quando abbiamo chiamato il package con il codice del drone `Drone`; in questo `package` era già presente una classe di nome `Drone`, perciò Java non riusciva a raccapezzarsi tra i riferimenti.
6. La creazione dei package ha portato alcune problematiche, abbiamo dovuto modificare il codice genato con il `GUI Builder` con un editor esterno. Per poi re-istanziare i vari componenti.
7. Implementando il comando `rc` abbiamo incontrato alcune difficoltà nella gestione delle movenze del drone. Per questo abbiamo dovuto fare dei test per calibrare i parametri per la sensibilità del movimento. Fortunatamente una volta che un movimento era ottimizzato, fare gli altri è stato molto più semplice.
8. Nel collegamento tra `ImageFrame` e `Status` abbiamo riscontrato qualche problema nel passaggio dei dati. Per questo ci siamo consultati (Michea con Alessandro), e abbiamo creato un nuovo metodo per passare le tre istruzioni (`pich`,`roll`,`yaw`) ai pannelli con le rappresentazioni del drone. Questo ci servirà in futuro per la gestione della parte grafica del progetto.

Ecco quindi le soluzioni riassunte:

>1. Utilizzo classe `Logger`.
>2. Approfondimento `Use Case`.
>3. Ricerche per comando `rc`.
>4. Nuova istanza di tipo `ImageFrame` e aggiunta riferimenti.
>5. Pulizia del codice.
>6. Trasferimento codice tra classi.
>7. Creazione `package`.
>8. `Package` rinominato.
>9. Creazione nuove istanze.
>10. Calibrazione tramite test di volo.
>11. Consultazione tra Michea e Alessandro.



## Punto della situazione rispetto alla pianificazione
Oggi abbiamo lavorato molto bene, ci siamo portati avanti rispetto ai giorni scorsi e finalmente abbiamo sistemato alcuni problemi o errori che ci portavamo dietro da settimane. Per questo siamo in tempo con la tabella di marcia.

## Programma di massima per la prossima giornata di lavoro

1. Sincronizzazione tra immagini del drone e movimenti del drone stesso.
2. Creazione della Live.
3. Finalizzazione controllo con tastiera (mantenimento dei tasti + pressione di tasti contemporaneamente).
4. Finalizzazione Leap Motion e calibrazione.
