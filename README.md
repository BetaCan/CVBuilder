# CV Builder (cvbuilder_6)

A compact Java Swing application to manage small repositories of CV fragments (User + Education sections) and assemble a custom CV from selected variants. This README documents project layout, how to run the app, data format, where to change behaviour, and development notes.

---

## Quick overview

- Purpose: Maintain multiple variants for Name, Title, Email and two Institution entries, select preferred variants and output a composed CV.
- UI: Java Swing desktop app (JFrame with panels per subsection).
- Data: CSV repository for variants + a selections row to assemble the Custom CV.
- Build: Maven-based Java project.

---

## Features

- Load a CSV repository (default: `data/cv_repo_6.csv`).
- Add / Edit / Delete variant strings per subsection.
- Select one variant per subsection (radio buttons) to compose a Custom CV.
- Save repository back to CSV.
- Print assembled CV to stdout (console).
- Simple file dialogs (Load / Open / Save / Print / Quit).

---

## Tech stack

- Java 17 (project compiled for Java 17)
- Maven (build & dependency management)
- Swing (javax.swing) for UI
- No external runtime libraries

---

## Project structure

```
src/main/java/cvbuilder/
├─ App.java                      # application entry — loads default CSV and starts UI
├─ temp.java
├─ controller/
│  ├─ AllSeeing.java
│  ├─ MenuProfileActions.java    # file menu actions: Load/Open/Save/Print/Quit
│  └─ UserProfileActions.java    # add/edit/delete/select actions for rows
├─ model/
│  └─ UserGroup.java             # in-memory model, CSV read/write, preview assembly
└─ view/
   ├─ AppMenuBar.java
   ├─ MainViewer.java            # main JFrame and tab layout
   ├─ Observer.java
   ├─ RowPanel.java              # single row UI (radio + edit + delete)
   └─ UserData.java              # panel bound to a list of variants

Other top-level files:
- pom.xml                        # Maven descriptor
- data/cv_repo_6.csv             # sample repository
- docs/CourseworkAssignmentBrief.md
```

---

## Getting started (build & run)

Prerequisites:

- Java 17 JDK installed
- Maven (optional: you can run from an IDE)

From project root:

1. Build:

```bash
mvn package
```

2. Run:

```bash
java -cp target/cvbuilder_6-1.0-SNAPSHOT.jar cvbuilder.App
```

Or run `cvbuilder.App` from your IDE (set working directory to project root so the `data/` folder is found).

---

## Usage (UI flow)

- On startup the app attempts to load `data/cv_repo_6.csv`.
- Main UI contains panels/tabs for:
  - Name, Title, Email (User section)
  - Institution 1, Institution 2 (Education)
- Per-row controls:
  - Radio button — select variant for composing the CV.
  - Edit — open input dialog to modify the variant text.
  - Delete — remove variant (no undo).
- Menu actions:
  - Load — reload default CSV repository.
  - Open — legacy plain-text loader (loads lines into Names).
  - Save — save current repository using `UserGroup.saveCSVFile(...)`.
  - Print — compose and print the current CV (`UserGroup.printCV()`).
  - Quit — exit the application.

---

## Data format (CSV)

File columns: `Section,Sub-Section,Variants`

- Section: `User`, `Education`, `Selections`
- Sub-Section: e.g., `Name`, `Title`, `Institution 1`
- Variants: comma-separated list of variant strings

Notes:

- Variants may contain commas/spaces; the code uses simple encode/decode markers when saving and reading:
  - See `src/main/java/cvbuilder/model/UserGroup.java` for the exact logic used by `readCSVFile()` and `saveCSVFile()`.
- `Selections` row stores the selected entries used to assemble the final CV.

Recommendation: migrate to JSON or use a robust CSV parser if you need multi-line or complex variant values.

---

## Where to change behaviour (quick guide)

- Default file loaded at startup:
  - `src/main/java/cvbuilder/App.java`
- CSV encoding/decoding and persistence:
  - `src/main/java/cvbuilder/model/UserGroup.java`
- Main UI layout and sections:
  - `src/main/java/cvbuilder/view/MainViewer.java`
- Row appearance and controls:
  - `src/main/java/cvbuilder/view/RowPanel.java`
- Panel binding and redraw logic:
  - `src/main/java/cvbuilder/view/UserData.java`
- Menu actions (Load/Open/Save/Print):
  - `src/main/java/cvbuilder/controller/MenuProfileActions.java`
- Add/Edit/Delete/Selection handlers:
  - `src/main/java/cvbuilder/controller/UserProfileActions.java`
- Global observer / notification:
  - `src/main/java/cvbuilder/view/Observer.java`

---

## Developer notes & TODOs

- Persist selections as structured IDs rather than raw text to avoid broken references when text changes.
- Replace ad-hoc CSV encoding with JSON or a proper CSV library to support multi-line and complex text.
- Add confirmation dialog for Delete and input validation for Edit/Add.
- Improve the Edit UI to support multi-line editing (JTextArea dialog).
- Add unit tests for `UserGroup` CSV read/write and for CV assembly (`generateTextPreview()`).
- Produce a runnable fat JAR (Maven shade or assembly plugin) for distribution.

---

## Example workflows

- Reload sample repository:

  1. File → Load
  2. UI refreshes lists from `data/cv_repo_6.csv`

- Compose and print CV:
  1. Select one radio per subsection
  2. File → Print (output appears on stdout / console)

---

## Contributing

- Use Git with clear, frequent commits.
- Keep changes scoped to your assigned CV sections per the coursework brief.
- To commit this README locally:

```bash
git add README.md
git commit -m "Replace README with detailed project documentation"
git push
```

---

## License & notes

This repository is the coursework starter for Software Development.
