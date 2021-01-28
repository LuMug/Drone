# Drone | Diario di lavoro
##### Michea Colautti, Alessandro Aloise, Gianni Grasso, Samuele Ganci
### Centro Professionale Trevano, 28.01.2021

## Lavori svolti


|Orario        |Lavoro svolto                                                |Eseguito da         |
|--------------|-------------------------------------------------------------|--------------------|
|08:20 - 08:40 | Riunione tra i compoenti del gruppo                         |Tutti               |
|08:30 - 08:40 | Definizione del GANTT finale                                |Tutti               |
|08:40 - 09:15 | Riuione con il docente                                      |Tutti               |
|09:15 - 09:50 | Definizione ambiente di lavoro Trello                       |Tutti               |
|10:05 - 10:10 | Spartizione dei compiti                                     |Tutti               |
|10:10 - 11:35 | Ricerca leap motion                                         |Samuele             |
|10:10 - 11:30 | Creazione interfaccia principale                            |Alessandro          |
|10:10 - 11:35 | Creazione classe drone                                      |Gianni              |
|10:10 - 10:40 | Diario                                                      |Michea              |
|10:40 - 11:35 | Creazione stilizzazzione drone con draw.io                  |Michea              |
|12:30 - 14:00 | Ricerca per SDK drone                                       |Gianni              |
|12:30 - 14:00 | Creazione socket comunicazione                              |Alessandro          |
|12:30 - 13:10 | Completata stilizzazzione drone con draw.io                 |Michea              |
|12:30 - 14:30 | Ricerca + prove implementazione Leap motion                 |Samuele             |
|13:10 - 13:30 | Aggiornamenti diario di lavoro                              |Michea              |
|13:30 - 14:56 | Diagramma di flusso con Draw.io (da rivedere)               |Michea              |
|14:00 - 15:15 | Instaurazione socket e test                                 |Alessandro e Gianni |
|14:30 - 15:45 | Interpretazione dati leap motion e ottenimento dati         |Samuele             |
|14:45 - 15:25 | Diario di lavoro con problematiche                          |Michea              |
|15:25 - 15:30 | Aggiornato file .gitignore (no file .DS_Store)              |Michea              |
|15:15 - 15:45 | Implementazione interfaccia grafica con codice comunicazine |Alessandro e Gianni |




## Problemi riscontrati e soluzioni adottate

1. La batteria non era ancora arrivata, quinidi questo ci ha un po' sballato i programmi per oggi. Ma, dopo la consulatazione con il docente, abbiamo deciso di procedere comunque, modificando leggermente l'approccio. Abbiamo quindi sfruttato il fatto che il `leap motion` fosse arrviato per cercare da subuto come interpretare i suoi dati, per poi utlizzarli nella comunicazione. Il nostro piano è quello di creare una comunicazione tra due `socket`, per simulare il drone e i suoi pacchetti `UDP`.

2. Per quanto riguarda il Trello, ci siamo consultati con il docente e abbiamo optato per un papproccio molto schematico. Ognuno si occuoerà di una singola attività inserita in Trello, che è sttao fatto piuttosoto specifico apposta. Questo ci permetterà di monitorare non solo l'andamento del progetto ma anche chi ha fatto cosa, così da sapere come agire in caso qualcosa non funzioni.

3. Un altro problema si è posto nella ricerca di informazioni per il sensore `leap motion`. Infatti in internet pochi siti erano chiari e in pochi parlavano di coeme gestire il sensore in `Java`. Tuttavia dopo una copnsultazione con il professore e una ricerca approfondita si è riusicti a trovare delle informazioni che hanno ci permesso di procedere nell'implementazione.

4. Stiamo avendo problemi nell'instaurazione del `socket` per la comunicazione. Dopo aver ri-letto il codice con attenzione abbiamo trovato il problema, avevamo scritto in maniera errata alcuni parametri della comunicazione (porta, ecc.)

5. Abbiamo avuto problemi a definire con precisione lo schema di flusso, per questo la prossima lezione ci confronteremo per apporre le eventuali modifiche per una maggiore precisione.

6. Durante le prove per ottenere i dati dal `leap motion` abbiamo dovuto intepretare molti dati. Inizialmente venivano restituiti solamente alcuni dati inutili (numero di dita ecc.). Per questo abbiamo dovuto fare altre ricerche per ottenere i dati giusti (posizione x,y,z)
7. Abbiamo avuto un problema nella comunicazione tra l'interfaccia e la logica sviluppata prima, abbiamo quindi simulato che un pc fosse il drone e l'altro pc generava dei comandi. Dopo alcuni test abbiamo trovato un errore di sintassi che faceva bloccare tutto.

Ecco quindi le soluzioni riassunte:

> 1. Ricerca `leap motion` e creazione di due socket da far comunicare.
> 2. Sviluppo schematico con Trello.
> 3. Ricerca approfondita e consultazione con il professore.
> 4. Rilettura del codice e correzzioni.
> 5. Riunione con il gruppo.
> 6. Ricerche e molti test.
> 7. Correzzione errore di sintassi nel codice

##  Punto della situazione rispetto alla pianificazione
Siamo nei tempi previsti, anche se abbiamo dovuto rivedere alcune tempistiche e precedenze dopo la consultazione con il professore e gli imprevisti sulla batteria.

## Programma di massima per la prossima giornata di lavoro
Vorremmo procedere con i lavori correnti, e approvare quelli svolti oggi, nello specifico:
1. Rivedere il diagramma di fulusso.
2. Riprendere e procedere con la gestione dell'interfaccia + comunicazione.
3. Riprendere il cotrollo tramite leap motion.
4. Se è arrivata la batteria, smettere di simulare il drone con un PC e usare il dorne appunto.
