
### Environment Setup
    
- Download [Gradle Dependency Management](https://gradle.org/install/) (For PaperMC)

    1. Download binaries and Extract `gradle-bin` folder anywhere.
    2. Create SYSTEM PATH to `gradle\bin`.
    3. Test installation with `gradle` command in Command Prompt.

- Install VSCode `Gradle for Java` & `Extension Pack for Java` extensions.

### Project setup

- In VSCode, run `>gradle`
    1. Select `Create Gradle Project` > `Kotlin` > Enter project name..
    2. Project created, open project folder in VSCode.
    3. Locate `build.gradle.kts` and move all files from its parent folder to the root project folder. Delete empty folder.

- Set up [PaperMc](https://docs.papermc.io/paper/dev/project-setup)
    1. Open `app/build.gradle.kts` to add PaperMc dependencies.
    2. Follow the rest of the steps in `docs.papermc.io`.

