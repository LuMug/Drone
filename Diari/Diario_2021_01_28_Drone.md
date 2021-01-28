# Drone | Diario di lavoro
##### Michea Colautti, Alessandro Aloise, Gianni Grasso, Samuele Ganci
### Centro Professionale Trevano, 28.01.2021

## Lavori svolti


|Orario        |Lavoro svolto                                                 |Eseguito da         |
|--------------|--------------------------------------------------------------|--------------------|
|08:20 - 08:40 | Riunione tra i componenti del gruppo                         |Tutti               |
|08:30 - 08:40 | Definizione del GANTT finale                                 |Tutti               |
|08:40 - 09:15 | Riunione con il docente                                      |Tutti               |
|09:15 - 09:50 | Definizione ambiente di lavoro Trello                        |Tutti               |
|10:05 - 10:10 | Spartizione dei compiti                                      |Tutti               |
|10:10 - 11:35 | Ricerca leap motion                                          |Samuele             |
|10:10 - 11:30 | Creazione interfaccia principale                             |Alessandro          |
|10:10 - 11:35 | Creazione classe drone                                       |Gianni              |
|10:10 - 10:40 | Diario                                                       |Michea              |
|10:40 - 11:35 | Creazione stilizzazione drone con draw.io                    |Michea              |
|12:30 - 14:00 | Ricerca per SDK drone                                        |Gianni              |
|12:30 - 14:00 | Creazione socket comunicazione                               |Alessandro          |
|12:30 - 13:10 | Completata stilizzazione drone con draw.io                   |Michea              |
|12:30 - 14:30 | Ricerca + prove implementazione Leap motion                  |Samuele             |
|13:10 - 13:30 | Aggiornamenti diario di lavoro                               |Michea              |
|13:30 - 14:56 | Diagramma di flusso con Draw.io (da rivedere)                |Michea              |
|14:00 - 15:15 | Instaurazione socket e test                                  |Alessandro e Gianni |
|14:30 - 15:45 | Interpretazione dati leap motion e ottenimento dati          |Samuele             |
|14:45 - 15:25 | Diario di lavoro con problematiche                           |Michea              |
|15:25 - 15:30 | Aggiornato file .gitignore (no file .DS_Store)               |Michea              |
|15:15 - 15:45 | Implementazione interfaccia grafica con codice comunicazione |Alessandro e Gianni |




## Problemi riscontrati e soluzioni adottate

1. La batteria non era ancora arrivata, quindi questo ci ha un po' sballato i programmi per oggi. Ma, dopo la consultazione con il docente, abbiamo deciso di procedere comunque, modificando leggermente l'approccio. Abbiamo quindi sfruttato il fatto che il `leap motion` fosse arrivato per cercare da subito come interpretare i suoi dati, per poi utilizzarli nella comunicazione. Il nostro piano è quello di creare una comunicazione tra due `socket`, per simulare il drone e i suoi pacchetti `UDP`.

2. Per quanto riguarda il Trello, ci siamo consultati con il docente e abbiamo optato per un approccio molto schematico. Ognuno si occuperà di una singola attività inserita in Trello, che è stato fatto piuttosto specifico apposta. Questo ci permetterà di monitorare non solo l'andamento del progetto ma anche chi ha fatto cosa, così da sapere come agire in caso qualcosa non funzioni.

3. Un altro problema si è posto nella ricerca di librerie per il sensore `leap motion`. Infatti in internet le librerie ufficiali erano reperibili solo dal sito del `leap motion`, eppure su quest'ultimo è risultato impossibile inizialmente trovare le SDK per sviluppare in `Java`. Successivamente dopo una consultazione con il professore e una ricerca approfondita si è riusciti a trovare in un link del sito ufficiale la SDK corretta aggiornata all'ultima versione. Ciò ci ha permesso di procedere nell'implementazione.

4. Abbiamo avuto problemi a definire con precisione lo schema di flusso, per questo la prossima lezione ci confronteremo per apporre le eventuali modifiche per una maggiore precisione.

5. Durante le prove per ottenere i dati dal `leap motion` abbiamo dovuto interpretare molti dati. Inizialmente venivano restituiti solamente alcuni dati inutili (numero di dita ecc.). Per questo abbiamo dovuto fare altre ricerche per ottenere i dati giusti (posizione x,y,z)

6. Abbiamo avuto un problema nella comunicazione tra il "simulatore del drone" e il PC. Infatti per questa parte abbiamo usato un programma di base già creato; esso era stato creato da Alessandro un anno fa, nell'ambito del modulo 226B.
Dopo aluni test abbiamo identificato un errore di trascrizione, dovuto alla trascrizione dal programma con l'intrfaccia grafica di base (sviluppato in precedenza da Alessandro) al nuovo programma.

	```java    
	public BottoniPanel() {
		initComponents();
		drone = new Drone(this);
		drone.start();
	}  
	```         

7. Abbiamo riscontrato un problema nella comunicazione con la simulazione dal drone citata in precedenza. Quando il PC iniava delle istruzioni al "simulatore del drone" esso, dopo aver ricevuto il messaggio, rispondeva ma il pc di partenza non riceveva alcun messaggio.            


Ecco quindi le soluzioni riassunte:


> 1. Ricerca `leap motion` e creazione di due socket da far comunicare.
> 2. Sviluppo schematico con Trello.
> 3. Ricerca approfondita e consultazione con il professore.
> 4. Riunione con il gruppo.
> 5. Ricerche e molti test.
> 6. Correzione errore di sintassi nel codice
> 7. Soluzione ancora da trovare

##  Punto della situazione rispetto alla pianificazione
Siamo nei tempi previsti, anche se abbiamo dovuto rivedere alcune tempistiche e precedenze dopo la consultazione con il professore e gli imprevisti sulla batteria.

## Programma di massima per la prossima giornata di lavoro
Vorremmo procedere con i lavori correnti, e approvare quelli svolti oggi, nello specifico:
1. Rivedere il diagramma di flusso.
2. Riprendere e procedere con la gestione dell'interfaccia + comunicazione.
3. Riprendere il controllo tramite leap motion.
4. Se sarà arrivata la batteria, smettere di simulare il drone con un PC e usare il drone.
