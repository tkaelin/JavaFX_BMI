## Content

BMI Calculator runs with JavaFX, created in Visual Studio Code. 
Version 4: Calculation starts on editing values. Different views are possible.

## Folder Structure

The Workspace contains two folders:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

The compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

## Installation

- [Download](https://code.visualstudio.com/download) and install VS Code
- Install the following packages in Visual Studio Code
  
| Package Name  | Extension Id  | 
|---|---|
| Extension Package for Java  | vscjava.vscode-java-pack | 
| Language Support for Java(TM) by redhat | redhat.java | 
| Debugger for Java  | vscjava.vscode-java-debug | 
| Project Manager for Java | vscjava.vscode-java-dependency |
| Test Runner for Java | vscjava.vscode-java-test | 

- Download and install the Java SDK and the JavaFX SDK as written on [Getting Started with JavaFX](https://openjfx.io/openjfx-docs/#install-java)
- Download this Repository
- Adapt the path to the JavaFX libraries in the files `.vscode/launch.json` and `.vscode/settings.json`
- Check if the right Java Runtime is configured (Ctrl+P and 'Configure Java Runtime')
- Run the application 