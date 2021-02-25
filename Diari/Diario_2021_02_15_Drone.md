# Drone | Diario di lavoro
##### Michea Colautti, Alessandro Aloise, Gianni Grasso, Samuele Ganci
### Centro Professionale Trevano, 25.02.2021

## Lavori svolti


|Orario        |Lavoro svolto                                                        |Eseguito da                 |
|--------------|---------------------------------------------------------------------|----------------------------|
|08:20 - 08:45 | Riunione di gruppo e resoconto del lavoro                           |Tutti                       |
|08:45 - 15:15 | Modifica e miglioramento di ImageTest                               |Michea                      |
|08:45 - 12:20 | Socket per comunicazione con drone (previa simulazione)             |Gianni e Alessandro         |
|08:45 - 09:15 | Fix percorsi netBeans (funzionanti su tutti i sistemi)              |Ganci                       |
|09:15 - 11:35 | Ricerca per movimenti drone (si vuole maggiore fluidità)            |Ganci                       |
|12:20 - 15:45 | Implementazione movimenti drone + calibrazione Leap Motion          |Ganci                       |
|12:20 - 14:00 | Live stream drone e aggiustamenti `Socket`                          |Gianni e Alessandro         |
|14:15 - 15:45 | Programma di base con frecce direzionali                            |Gianni                      |
|14:15 - 15:45 | Ricerca SDK drone + aggiornamento                                   |Alessandro                  |
|15:15 - 15:45 | Scrittura Diario			                                             |Michea                      |



## Problemi riscontrati e soluzioni adottate

Come prima cosa c'è da dire che oggi abbiamo lavorato in maniera particolare: non ci siamo occupati di molte cose, come del resto si può vedere nella tabella qui sopra, ma ci siamo occupati di mancanze grosse da implementare.

1. Benché la scuola ci avesse fornito una batteria, siamo stati molto rallentati nel lavorare. Infatti il drone stava in volo pochi minuti, scaricandosi molto in fretta. Per contro la batteria doveva essere costantemente ricaricata, processo che prendeva molto tempo.
2. Nell'implementare il programma di guida del `Leap Motion` java dava errore, per esempio tornava valori troppo alti o sottozero. speso bastava eseguire una build e pulire il programma perché tornasse a funzionare
3. Il `Leap Motion` non veniva più rilevato, abbiamo non solo dovuto riavviare il PC, ma eseguire del `TroubleShooting Step-by-Step`, fino a correggere il problema 
4. Il ‘Socket’ da noi creato non veniva instaurato. Anche dopo aver letto con attenzione il manuale DJI Tello per quanto riguarda questo aspetto della connessione non riuscivamo ad ottener risultai soddisfacenti. Infatti non riuscivamo a comunicare con il drone. Siamo riusciti infine a correggere l'errore sistemando un metodo e disattivando l'antivirus su uno dei nostri PC.
5. Le connessioni da noi instaurate, non ricevano alcuna risposta. Il PC si connetteva quindi al drone, ma esso non dava alcun segno di vita. Dopo ricerche abbiamo concluso che l'errore stava nella versione dell'`SDK` del drone. Abbiamo dovuto quindi aggiornare l'`SDK` del drone.
6. Per aggiornare ci è voluto molto tempo, a causa della batteria scarica abbiamo dovuto procedere un aggiornamento alla volta, aspettando che il drone si caricasse tra un aggiornamento e l'altro.
7. Durante la creazione della classe ImageTest abbiamo riscontrato molte difficoltà. Con l'approccio iniziale i comandi della tastiera con `KeyListener` non erano ricevuti dai vari pannelli con le differenti immagini. Perciò abbiamo dovuto creare un `Frame` nuovo, inizializzare tutti i componenti e aggiungerli manualmente al `Frame`.
8. Anche dopo aver creato il `Frame` nuovo, i comandi non erano ancora rilevati. Perciò l'unico `ascoltatore` di eventi è diventato il `Frame`, che ora richiama i vari metodi per il controllo contenuti nei vari `Panel`
9. Una volta che i comandi erano pronti, abbiamo dovuto ottimizzare il processo di disegno. Questo ha preso abbastanza tempo e molti tentativi, per creare un meccanismo di movimento buono e affidabile.
10. Una volta creato questo meccanismo è stato ulteriormente migliorato. Questo perché ogni pannello aveva il suo movimento, ma con le dovute modifiche abbiamo potuto alleggerire un codice che sarebbe risultato di difficile comprensione e inutilmente lento.
11. Quando le immagini si muovevano ci siamo resi conto di un problema. Rimanevano inclinate anche se l'utente rilasciava il tasto per il movimento, e non è così che si comporta un vero drone. Infatti se viene fatto andare a destra, il drone si inclina si verso destra, ma non rimarrà così all'infinto; quando il pilota smette di premere il tasto per la virata il drone torna in posizione neutra. Abbiamo dovuto creare un meccanismo per farlo tornare alla posizione originale. (Usando `KeyReleased`).

Ecco quindi le soluzioni riassunte:


> 1. Pulizia automatica del codice
> 2. Ri-scrittura variabili `Leap Motion` e riavvio PC
> 3. Fix metodo errato e disattivazione Firewall
> 4. Aggiornare `SDK` drone
> 5. Utilizzo `Frame` principale
> 6. Comunicazione `KeyListener` tra `Frame` e `Panels`
> 7. Test e ottimizzazione disegno
> 8. Meccanismo di ritorno in posizione neutra



## Punto della situazione rispetto alla pianificazione
Siamo in tempo, dobbiamo tuttavia aggiornare il nostro GANTT.


## Programma di massima per la prossima giornata di lavoro
1. Vogliamo andare avanti con il `’Socket’`, visto che funzionava a fine lezione, implementeremo così lo streaming video.
2. Vogliamo anche portarci avanti con la gestione dei movimenti con il `Leap Motion`.
3. Forse inizieremo a sviluppare la `GUI` Web, e ricercheremo come implementare un `Frame` Java in un contesto WEB.
4. Vogliamo aggiornate il GANTT.

