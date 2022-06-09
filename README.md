## Content

BMI Calculator that runs with JavaFX. The application is using the MVC design pattern.

## Folder Structure

The Workspace contains two folders:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

The compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view (in Visual Studio Code) allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

## Installation and Execution

There are a lot of ways to build and execute this application. In every case, you have to download and install the Java SDK and the JavaFX SDK as written on [Getting Started with JavaFX](https://openjfx.io/openjfx-docs/#install-java).

<details>
<summary>Using Java native (from the Command Line)</summary>
 
1) Define an environment variable with the path to the JavaFX "/lib" folder
   `set JAVAFX_HOME={path to JavaFX "lib" folder}`

2) Build the application
   `javac --module-path "%JAVAFX_HOME%" --add-modules "javafx.controls,javafx.fxml" -d ./bin  ./src/*.java`

3) Run the application
   `java --module-path "%JAVAFX_HOME%" --add-modules "javafx.controls,javafx.fxml" -cp ./bin App`

</details>


<details>
<summary>Using Intellij</summary>

1) [Download](https://www.jetbrains.com/de-de/idea/download/) and install Intellij
2) Add the JavaFX module to the project
   1) Open Project Structure
   2) Click on the "Global Libraries" tab
   3) Click on the "Add" button
   4) Click on Java
   5) Navigate to the JavaFX installation folder and then to lib and select the following modules
      - javafx-base
      - javafx-controls
      - javafx-fxml
      - javafx-graphics
      - javafx-media
      - javafx-swing
      - javafx-web
3) Add a new run configuration for the application
   1) Open Run Configurations (click on the "Run" button)
   2) Click on the "Add" button
   3) Click on the "Application" button
   4) Select your Java JDK from the dropdown
   5) Select your Main class
   6) Click on the "Modify Options" > "VM Options" button
   7) Add the following VM options: `--module-path {path to JavaFX "lib" folder} --add-modules javafx.controls,javafx.base,javafx.fxml,javafx.graphics,javafx.media,javafx.web --add-exports=javafx.graphics/com.sun.javafx.util=ALL-UNNAMED --add-exports=javafx.base/com.sun.javafx.reflect=ALL-UNNAMED
   8) Click on the "OK" button
5) Run the application (Shift + F10)
</details>

<details>
<summary>Using Visual Studio Code</summary>

1) [Download](https://code.visualstudio.com/download) and install VS Code
2) Install the following packages in Visual Studio Code

| Package Name  | Extension Id  | 
|---|---|
| Extension Package for Java  | vscjava.vscode-java-pack | 
| Language Support for Java(TM) by redhat | redhat.java | 
| Debugger for Java  | vscjava.vscode-java-debug | 
| Project Manager for Java | vscjava.vscode-java-dependency |
| Test Runner for Java | vscjava.vscode-java-test | 

3) Adapt the path to the JavaFX libraries in the files `.vscode/launch.json` and `.vscode/settings.json`
4) Check if the right Java Runtime is configured (Ctrl+P and 'Configure Java Runtime')
5) Run the application (F5 or Ctrl-F5)

</details>

<br>
