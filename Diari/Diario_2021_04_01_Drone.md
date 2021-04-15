# Drone | Diario di lavoro
##### Michea Colautti, Alessandro Aloise, Gianni Grasso, Samuele Ganci
### Centro Professionale Trevano, 01.04.2021

## Lavori svolti


|Orario        |Lavoro svolto                                                        |Eseguito da                 |
|--------------|---------------------------------------------------------------------|----------------------------|
|08:20 - 09:00 | Riunione mattutina con tutti i componenti del gruppo                | Tutti                      |
|09:00 - 09:50 | Sviluppo sito Web                                                   | Alessandro                 |
|09:00 - 09:50 | Ricerca per live stream                                             | Gianni                     |
|09:00 - 09:50 | Creazione icone sito e ordine nella cartella "Documenti"            | Michea                     |
|09:00 - 09:50 | Ricerca e fix errori Leap Motion                                    | Samuele                    |
|10:05 - 11:35 | Fix progetto e pannelli + unione di tutti i codici                  | Alessandro e Gianni        |
|10:05 - 10:45 | Fix errore Leap                                                     | Samuele e Michea           |
|10:45 - 11:35 | Miglioramento e pulizia del codice del Leap Motion                  | Samuele                    |
|12:30 - 13:15 | Riunione generale + consulto docente                                | Tutti                      |
|13:15 - 14:00 | Test finale LeapMotion                                              | Samuele                    |
|13:45 - 14:00 | Modifica di Log e Status                                            | Alessandro                 |
|13:15 - 15:45 | Proseguito sviluppo live                                            | Gianni                     |
|14:00 - 15:45 | Sviluppo ImageFrame                                                 | Michea                     |
|14:15 - 15:10 | Test LeapMotion e miglioramento di atterraggio e decollo            | Samuele                    |
|15:00 - 15:45 | Migliorato il sistema di registrazione dei comandi                  | Samuele                    |





## Problemi riscontrati e soluzioni adottate


1. Dopo alcuni test ci siamo accorti che il nostro progetto non funzionava con Mac. Infatti il `Leap Motion` smetteva di leggere le informazioni e si interrompeva. Dopo alcune ricerche abbiamo ri-scaricato le librerie `.jar`, e ha funzionato.
2. La registrazione dei comandi continuava dopo il decollo, e questo causava problemi di interferenza, per questo è stata limitata la registrazione dal decollo all'atterraggio.
3. Abbiamo finalmente sistemato il problema che si presentava al trascinamento di `ComandiPanel` e `FunzionePanel` all'interno di `DroneFrame`. L'errore generato riguardava delle dipendenze e delle classi non trovate o impossibile istanziare, sollevando delle `NullPointerException` o `NoClassDeffoundError`. La classe che generava il tutto però era `Drone`. Abbiamo risolto il problema riscrivendo in modo migliore il codice e ripulendolo, infine abbiamo spostato le istanze e i riferimenti di altre classi all'interno del costruttore in un altro posto, sempre all'interno di `Drone`.
4. Durante la riunione con il professore abbiamo svolto molti test, questo ci ha permesso di invidiare molti problemi:
5. Primo fra tutti era come prendevamo i dati da `Status`. Infatti i dati `roll` `pitch` `yaw` `altitude`, venivano presi male, risultando sempre 0. abbiamo dovuto stampare una stringa intera del messaggio di default del drone per poter poi trovare i dati giusti tramite `tokenizer`.
6. Il secondo problema evidenziato è il metodo con cui `ImageFrame` catturava i movimenti. Infatti, prenderli direttamente dal `Leap Motion` non è una buona idea, in quanto quei dati sono frutto di un calcolo. Per questo abbiamo deciso di prelevare i dati da `Status`. Questa volta abbiamo dovuto implementare `Runnable`, così che ci sia un metodo che sia non solo capace di prendere dei dati in continuazione da `Status`, ma che permetta anche il movimento di più immagini contemporaneamente.
7. Una volta fatto il metodo con la `Thread` in `ImageFrame`, è bastato alleggerire i metodi presenti nei vari pannelli delle immagini e nel modello di classe da noi definito. 



## Punto della situazione rispetto alla pianificazione

Siamo in tempo con i tempi previsti.
## Programma di massima per la prossima giornata di lavoro
1. Finire collegamento immagini-drone.
2. Procedere con Live.
3. Panel statistiche.

