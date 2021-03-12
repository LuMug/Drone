# Drone | Diario di lavoro
##### Michea Colautti, Alessandro Aloise, Gianni Grasso, Samuele Ganci
### Centro Professionale Trevano, 11.03.2021

## Lavori svolti


|Orario        |Lavoro svolto                                                        |Eseguito da                 |
|--------------|---------------------------------------------------------------------|----------------------------|
|08:20 - 08:30 | Riunione mattutina		                                             |Tutti                       |
|08:30 - 09:15 | GANTT consuntivo                                                    |Samuele                     |
|08:30 - 09:00 | Modifica programma di guida con frecce direzionali                  |Gianni e Michea             |
|08:30 - 09:15 | Registrazione in un file video drone                                |Alessandro                  |
|09:00 - 09:45 | Test di volo con tasti e ricerca per movimenti fluidi               |Gianni e Michea             |
|09:15 - 09:50 | Aiuto fix Netbeans Alessandro                                       |Samuele e Alessandro        |
|10:05 - 11:35 | Documentazione e riordinamento files progettazione                  |Samuele                     |
|10:05 - 11:35 | Ricerca per dati statistici del drone                               |Alessandro                  |
|10:05 - 11:35 | Implementazione comando rc                                          |Gianni e Michea             |
|12:30 - 13:00 | Documentazione                                                      |Samuele                     |
|12:30 - 15:00 | Ricerca + implementazione interfaccia per statistiche               |Alessandro                  |
|12:30 - 15:45 | Implementazione e calibrazione guida con frecce direzionali         |Gianni                      |
|12:30 - 14:00 | Ricerca per implementare la possibilità di premere più tasti        |Michea                      |
|13:00 - 13:15 | Stesura proprio diario                                              |Samuele                     |
|13:15 - 13:40 | Consultazione Gianni per muovere fluidamente il drone               |Samuele                     |
|13:40 - 14:00 | Ricerca fluidità dei comandi RC + setSpeed                          |Samuele                     |
|14:00 - 14:45 | Ricerca e download software per creazione DB Sqlite                 |Michea                      |
|14:15 - 15:45 | Implementazione del LeapMotion in modo fluido (con comando RC)      |Samuele                     |
|15:00 - 15:45 | Classe di log                                                       |Alessandro                  |
|15:00 - 15:45 | Discussione ER + implementazione DB in Sqlite                       |Michea                      |

## Problemi riscontrati e soluzioni adottate

1. Come primo problema abbiamo affrontato l'interfaccia di guida tramite le frecce. Volevamo capire bene a che punto fosse il nostro lavoro e cosa dovessimo ancora modificare per renderlo più fluido. Dopo aver constatato che i nostri comandi si sommavano uno con l'altro, facendo entrare il drone in una sequenza continua di istruzioni, abbiamo dovuto ingeneraci. Siccome il comando `stop` non era compatibile con la nostra `SDK`, abbiamo fatto delle ricerche in internet. Abbiamo così scoperto il comando `rc`, un comando per la guida del drone.
2. Mentre sviluppavamo il codice per la registrazione dello stream video del drone siamo incappati in un problema co il file `mp4`. Esso infatti veniva correttamente creato, ma al momento di essere finalizzato il `Socket` non veniva chiuso. Il file `mp4` non poteva così avere la `tail`, quindi non era leggibile.
***Dobbiamo ancora trovare la soluzione***
3. Prima di poter risolvere il problema precedente, abbiamo avuto un altro problema, infatti non funzionava la build perché non veniva trovato uno dei file `dll`
essenziali per il funzionamento del programma. Alla fine abbiamo scoperto che mancava qualche pacchetto dell'`SDK`, probabilmente qualcosa con  perché gli mancava `C++`
4. Abbiamo implementato il comando `rc`, la problematica principale è che con questo comando il drone sembra entrare in un loop infinito in cui esegue sempre le stesse istruzioni. Tuttavia per confermare questo nostro sospetto dobbiamo creare una classe di log, che inserisca in un file tutte le istruzioni.
5. Anche nel `Leap Motion` ci siamo accorti che i comandi andavano aggiornati, più che altro perché dovevamo rendere il sistema di pilotaggio uniforme. Perciò dopo una riunione tra di noi abbiamo deciso di usare tutti quanti il comando `rc`, che ci sembrava la soluzione migliore.
6. Inizialmente pensavamo di dover creare un DB complesso, con `Trigger` eccetera; in realtà ci siamo accorti in fase di progettazione che sarebbe bastata un’unica tabella. Inoltre grazie al comando `rc`, l'istruzione da salvare l'istruzione eseguita facilmente, in un unico campo. L'unica cosa che abbiamo dovuto aggiungere è stato un `id` per la sequenza. In questo modo l'utente potrà registrare tranquillamente più istruzioni.
7. Nella stesura della classe `Logger`, che per ora è solamente un prototipo, abbiamo dovuto rendere i parametri statici, poiché veniva restituito un errore di compatibilità. Dato che il `Logger` sarà una classe totalmente indipendente dal resto del progetto non dovremmo avere problemi.

Ecco quindi le soluzioni riassunte:

> 1. Ricerca informazioni `SDK` e implementazione `rc`.
> 2. Download libreria e nuova installazione.
> 3. Inizio creazione di una classe `Logger`.
> 4. Conversione programma `Leap Motion`, per adattarlo al comando `rc`.
> 5. Utilizzo di membri statici.


## Punto della situazione rispetto alla pianificazione
Oggi abbiamo fatto buoni progressi e dovremmo avere la base per recuperare tutto il lavoro arretrato.

## Programma di massima per la prossima giornata di lavoro
1. Terminare classe `Logger`.
2. Terminare registrazione video drone.
3. Implementare la possibilità di controllare il drone con più tasti contemporaneamente.
4. Calibrazione ulteriore `Leap Motion`.
5. Risoluzione comandi "infiniti" con `rc`.
