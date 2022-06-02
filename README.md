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

Following you will find the process description for this two options
- Java native (from the Command Line)
- Visual Studio Code


### Java native
1) Define an environment variable with the path to the JavaFX "/lib" folder
`set JAVA_HOME={path to JavaFX "lib" folder}`

2) Build the application
`javac --module-path "%JAVAFX_HOME%" --add-modules "javafx.controls,javafx.fxml" -d ./bin  ./src/*.java`

3) Run the application
`java --module-path "%JAVAFX_HOME%" --add-modules "javafx.controls,javafx.fxml" -cp ./bin App`


### Using Visual Studio Code

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