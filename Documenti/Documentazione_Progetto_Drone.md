1. [Introduzione](#introduzione)

  - [Informazioni sul progetto](#informazioni-sul-progetto)

  - [Abstract](#abstract)

  - [Scopo](#scopo)

2. [Analisi](#analisi)

  - [Analisi del dominio](#analisi-del-dominio)
  
  - [Analisi dei mezzi](#analisi-dei-mezzi)

  - [Analisi e specifica dei requisiti](#analisi-e-specifica-dei-requisiti)

  - [Use case](#use-case)

  - [Pianificazione](#pianificazione)

3. [Progettazione](#progettazione)

  - [Design dell’architettura del sistema](#design-dell’architettura-del-sistema)

  - [Design dei dati e database](#design-dei-dati-e-database)

4. [Implementazione](#implementazione)

5. [Test](#test)

  - [Protocollo di test](#protocollo-di-test)

  - [Risultati test](#risultati-test)

  - [Mancanze/limitazioni conosciute](#mancanze/limitazioni-conosciute)

6. [Consuntivo](#consuntivo)

7. [Conclusioni](#conclusioni)

  - [Sviluppi futuri](#sviluppi-futuri)

  - [Considerazioni personali](#considerazioni-personali)

8. [Sitografia](#sitografia)

9. [Allegati](#allegati)


## Introduzione

### Informazioni sul progetto

Allievi coinvolti nel progetto: Samuele Ganci, Alessandro Aloise, Michea Colautti, Gianni Grasso.
Classe: I3AA, I3AC, Scuola Arti e Mestieri Trevano, sezione informatica.
Docenti responsabili: Luca Muggiasca.
Data inizio: 14 gennaio 2021.
Data di consegna: 13 maggio 2021.

### Abstract

  > *Nowadays, technology around us is costantly evolving, even becoming vital. Thanks
  to computer system, the way we entertain ourselves has changed in recent times,
  technology enternains us. Recently, aumented reality devices such as VR devices,
  hands and arms sensors, and more. These things have become increasingly common in the
  market. In this project we managed to implement piloting a drone with our hands, thanks
  to the help of a device called Leap Motion. With little money now you can buy
  a Leap Motion and a Drone to be able to enjoy driving the DJI Tello using only
  your hands in a very intuitive and simple way.*

### Scopo

  Lo scopo del progetto, è di creare un software in grado di interagire con le nostre
  mani, di rilevarne i movimenti e trasformando quest'ultimi in dati, inviarli ad un drone.
  Molto più semplicemente, grazie ad un dispositivo di nome Leap Motion, muovendo
  semplicemente le mani, dobbiamo essere in grado di muovere nello spazio un drone.
  
## Analisi

### Analisi del dominio

  È stato richiesto di creare un'interfaccia di controllo utile a pilotare un drone DJI Tello, il
  movimento del velivolo deve avvenire tramite lo spostamento di entrambe le mani, inoltre, deve
  essere visualizzato a schermo il video del drone in streaming. Una mano si occupa di imbardata,
  beccheggio e rollio, l'altra invece dell'altitudine. Deve inoltre essere possibile registrare una
  sequenza di comandi per poi poterla far riprodurre dal drone successivamente in modo autonomo.
  
  Deve essere inoltre creata un'ulteriore interfaccia che deve avere 4 riquadri, che rappresenteranno
  in 2D in forma stilizzata rispettivamente l'imbardata, il beccheggio, il rollio e l'altitudine del drone.
  
  Le interfacce perciò si devono occupare dei dati ricevuti dal drone, e successivamente
  fare in modo di renderli reperibili in una pagina web sotto forma di statistica.
  
  Il tutto deve essere programmato in Java.

### Analisi e specifica dei requisiti

  ||**ID: Req-001**|
  |----|-
  |**Nome**| Interfaccia controllo Drone |
  |**Priorità**|1|
  |**Versione**|1.1|
  |**Note**|Utilizzare Java. La connessione al drone deve avvenire tramite protocollo UDP|
  ||**Sotto requisiti**|
  |**001**|Realizzare un'interfaccia utile a pilotare il drone con i tasti virtuali del programma|
  |**002**|Implementare il pilotaggio con i tasti fisici del PC|
  |**003**|Implementare il pilotaggio con il Leap Motion, la mano sinistra si occupa del movimento verticale, mentre la destra si occupa di tutti gli altri movimenti|
  |**004**|Realizzare il frame con lo streaming del video del drone|
  |**005**|Implementare la funzione di salvataggio di sequenze di comandi. Successivamente fare in modo di farle riprodurre dal drone in modo autonomo|
  
  ||**ID: Req-002**|
  |----|-
  |**Nome**| Interfaccia posizione Drone |
  |**Priorità**|1|
  |**Versione**|1.0|
  |**Note**|Utilizzare Java|
  ||**Sotto requisiti**|
  |**001**|Realizzare un'interfaccia con 4 riquadri, raffiguranti rispettivamente l’imbardata, il beccheggio, il rollio e l’altitudine del drone. Le immagini devono essere in 2D e stilizzate |
  
  ||**ID: Req-003**|
  |----|-
  |**Nome**| Interfaccia statistiche |
  |**Priorità**|1|
  |**Versione**|1.0|
  |**Note**|Inizialmente sito web, su accordo è stato modificato in interfaccia. Utilizzare Java|
  ||**Sotto requisiti**|
  |**001**|Realizzare un'ulteriore interfaccia che rappresenta i dati ritornati dal drone sottoforma di statistica.|

### Use case

Ecco il nostro Use Case
![Use Case](/Users/micheacolautti/Documents/GitHub/Drone/Documenti/Progettazione/Use_Case/UseCase.png)

### Pianificazione

Prima di stabilire una pianificazione bisogna avere almeno una vaga idea
del modello di sviluppo che si intende adottare. In questa sezione
bisognerà inserire il modello concettuale di sviluppo che si seguirà
durante il progetto. Gli elementi di riferimento per una buona
pianificazione derivano da una scomposizione top-down della problematica
del progetto.

La pianificazione può essere rappresentata mediante un diagramma di
Gantt.

Se si usano altri metodi di pianificazione (es scrum), dovranno apparire
in questo capitolo.

### Analisi dei mezzi

 **Software**
 - Java JDK 14.0.2
 - Leap Motion SDK 3.2.1
 - Tello SDK 2.0
 - Apache Netbeans IDE 12.0
 
 **Hardware**
- Laptop personali
- PC scolastici
- Drone DJI Tello
- Leap Motion

## Progettazione

Questo capitolo descrive esaustivamente come deve essere realizzato il
prodotto fin nei suoi dettagli. Una buona progettazione permette
all’esecutore di evitare fraintendimenti e imprecisioni
nell’implementazione del prodotto.

### Design dell’architettura del sistema

Descrive:

-   La struttura del programma/sistema lo schema di rete...

-   Gli oggetti/moduli/componenti che lo compongono.

-   I flussi di informazione in ingresso ed in uscita e le
    relative elaborazioni. Può utilizzare *diagrammi di flusso dei
    dati* (DFD).

-   Eventuale sitemap

### Design dei dati e database

Descrizione delle strutture di dati utilizzate dal programma in base
agli attributi e le relazioni degli oggetti in uso.

### Schema E-R, schema logico e descrizione.

Se il diagramma E-R viene modificato, sulla doc dovrà apparire l’ultima
versione, mentre le vecchie saranno sui diari.

### Design delle interfacce

Descrizione delle interfacce interne ed esterne del sistema e
dell’interfaccia utente. La progettazione delle interfacce è basata
sulle informazioni ricavate durante la fase di analisi e realizzata
tramite mockups.

### Design procedurale

Descrive i concetti dettagliati dell’architettura/sviluppo utilizzando
ad esempio:

-   Diagrammi di flusso e Nassi.

-   Tabelle.

-   Classi e metodi.

-   Tabelle di routing

-   Diritti di accesso a condivisioni …

Questi documenti permetteranno di rappresentare i dettagli procedurali
per la realizzazione del prodotto.

## Implementazione

In questo capitolo dovrà essere mostrato come è stato realizzato il
lavoro. Questa parte può differenziarsi dalla progettazione in quanto il
risultato ottenuto non per forza può essere come era stato progettato.

Sulla base di queste informazioni il lavoro svolto dovrà essere
riproducibile.

In questa parte è richiesto l’inserimento di codice sorgente/print
screen di maschere solamente per quei passaggi particolarmente
significativi e/o critici.

Inoltre dovranno essere descritte eventuali varianti di soluzione o
scelte di prodotti con motivazione delle scelte.

Non deve apparire nessuna forma di guida d’uso di librerie o di
componenti utilizzati. Eventualmente questa va allegata.

Per eventuali dettagli si possono inserire riferimenti ai diari.

## Test

### Protocollo di test

Definire in modo accurato tutti i test che devono essere realizzati per
garantire l’adempimento delle richieste formulate nei requisiti. I test
fungono da garanzia di qualità del prodotto. Ogni test deve essere
ripetibile alle stesse condizioni.


|Test Case      | TC-001                               |
|---------------|--------------------------------------|
|**Nome**       |Import a card, but not shown with the GUI |
|**Riferimento**|REQ-012                               |
|**Descrizione**|Import a card with KIC, KID and KIK keys with no obfuscation, but not shown with the GUI |
|**Prerequisiti**|Store on local PC: Profile\_1.2.001.xml (appendix n\_n) and Cards\_1.2.001.txt (appendix n\_n) |
|**Procedura**     | - Go to “Cards manager” menu, in main page click “Import Profiles” link, Select the “1.2.001.xml” file, Import the Profile - Go to “Cards manager” menu, in main page click “Import Cards” link, Select the “1.2.001.txt” file, Delete the cards, Select the “1.2.001.txt” file, Import the cards |
|**Risultati attesi** |Keys visible in the DB (OtaCardKey) but not visible in the GUI (Card details) |


### Risultati test

Tabella riassuntiva in cui si inseriscono i test riusciti e non del
prodotto finale. Se un test non riesce e viene corretto l’errore, questo
dovrà risultare nel documento finale come riuscito (la procedura della
correzione apparirà nel diario), altrimenti dovrà essere descritto
l’errore con eventuali ipotesi di correzione.

### Mancanze/limitazioni conosciute

Descrizione con motivazione di eventuali elementi mancanti o non
completamente implementati, al di fuori dei test case. Non devono essere
riportati gli errori e i problemi riscontrati e poi risolti durante il
progetto.

## Consuntivo

Consuntivo del tempo di lavoro effettivo e considerazioni riguardo le
differenze rispetto alla pianificazione (cap 1.7) (ad esempio Gannt
consuntivo).

## Conclusioni

Quali sono le implicazioni della mia soluzione? Che impatto avrà?
Cambierà il mondo? È un successo importante? È solo un’aggiunta
marginale o è semplicemente servita per scoprire che questo percorso è
stato una perdita di tempo? I risultati ottenuti sono generali,
facilmente generalizzabili o sono specifici di un caso particolare? ecc

### Sviluppi futuri
  Migliorie o estensioni che possono essere sviluppate sul prodotto.

### Considerazioni personali
  Cosa ho imparato in questo progetto? ecc

## Bibliografia

### Bibliografia per articoli di riviste
1.  Cognome e nome (o iniziali) dell’autore o degli autori, o nome
    dell’organizzazione,

2.  Titolo dell’articolo (tra virgolette),

3.  Titolo della rivista (in italico),

4.  Anno e numero

5.  Pagina iniziale dell’articolo,

### Bibliografia per libri


1.  Cognome e nome (o iniziali) dell’autore o degli autori, o nome
    dell’organizzazione,

2.  Titolo del libro (in italico),

3.  ev. Numero di edizione,

4.  Nome dell’editore,

5.  Anno di pubblicazione,

6.  ISBN.

### Sitografia

1.  URL del sito (se troppo lungo solo dominio, evt completo nel
    diario),

2.  Eventuale titolo della pagina (in italico),

3.  Data di consultazione (GG-MM-AAAA).

**Esempio:**

-   http://standards.ieee.org/guides/style/section7.html, *IEEE
    Standards Style Manual*, 07-06-2008.

## Allegati

Elenco degli allegati, esempio:

-   Diari di lavoro

-   Codici sorgente/documentazione macchine virtuali

-   Istruzioni di installazione del prodotto (con credenziali
    di accesso) e/o di eventuali prodotti terzi

-   Documentazione di prodotti di terzi

-   Eventuali guide utente / Manuali di utilizzo

-   Mandato e/o Qdc

-   Prodotto

-   …
