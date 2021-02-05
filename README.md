# Título del Proyecto

The Movies Chiper

## Comenzando 🚀

_Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas._

### Pre-requisitos 📋

_Que cosas necesitas para instalar el software y como instalarlas_

Necesitas Android Studio

Para instalar Android Studio en Windows, haz lo siguiente:

1. Si descargaste un archivo .exe (recomendado), haz doble clic en él para iniciarlo.
2. Si descargaste un archivo .zip, extráelo y copia la carpeta android-studio en la carpeta Archivos de programa. A continuación, abre la carpeta android-studio > bin y, luego, inicia studio64.exe (para máquinas de 64 bits) o studio.exe(para las de 32 bits).

Sigue los pasos del asistente de configuración en Android Studio y asegúrate de instalar los paquetes de SDK que recomiende.

Para instalar Android Studio en tu Mac, haz lo siguiente:

1. Ejecuta el archivo DMG de Android Studio.
2. Arrastra y suelta Android Studio en la carpeta Aplicaciones y, luego, inícialo.
3. Elige si deseas importar configuraciones anteriores de Android Studio y, luego, haz clic en OK.
4. El asistente de configuración de Android Studio te guiará por el resto de la configuración, lo que incluye la descarga de los componentes del SDK de Android que se necesiten para el desarrollo.

Para instalar Android Studio en Linux, haz lo siguiente:

1. Extrae el archivo .zip que descargaste en una ubicación apropiada para tus aplicaciones, como dentro de /usr/local/ para tu perfil de usuario o /opt/ para usuarios compartidos.
2. Si usas una versión de Linux de 64 bits, asegúrate de instalar primero las bibliotecas requeridas para máquinas de 64 bits.

3. Para iniciar Android Studio, abre una terminal, navega al directorio android-studio/bin/ y ejecuta studio.sh.
4. Selecciona si deseas o no importar configuraciones anteriores de Android Studio y, luego, haz clic en OK.
5. El asistente de configuración de Android Studio te guiará por el resto de la configuración, lo que incluye la descarga de los componentes del SDK de Android que se necesiten para el desarrollo.

### Instalación 🔧



Debes descargar el proyecto desde la ruta de github https://github.com/MikeMC777/TheMovies.git

Debes descomprimir el proyecto en tu equipo local, inicias el entorno de desarrollo de Android Studio, en el menú "Archivo" selecciona la opción "Abrir" y buscas la ruta donde descargaste el proyecto y lo seleccionas.

## Ejecutando las pruebas ⚙️

A fin de crear una prueba instrumentada o de unidad local, puedes crear una prueba nueva para una clase o un método específicos siguiendo estos pasos:

Abre el archivo Java que contenga el código que desees probar.
Haz clic en la clase o el método que desees probar y, luego, presiona Ctrl + mayúscula + T (⇧⌘T).
En el menú que aparece, haz clic en Create New Test.
En el diálogo Create Test, edita cualquier campo, selecciona cualquier método que quieras generar y haz clic en OK.
En el diálogo Choose Destination Directory, haz clic en el conjunto de orígenes correspondiente al tipo de prueba que desees crear: androidTest para una prueba instrumentada o test para una prueba de unidad local. Luego, haz clic en OK.
Como alternativa, puedes crear un archivo Java genérico en el conjunto de orígenes de pruebas correspondiente de la siguiente manera:

En la ventana Project ubicada a la izquierda, haz clic en el menú desplegable y selecciona la vista Project.
Expande la carpeta de módulos correspondientes y la carpeta anidada src. Para agregar una prueba de unidad local, expande la carpeta test y la carpeta anidada java; para agregar una prueba instrumentada, expande la carpeta androidTest y la carpeta anidada java.
En el directorio del paquete de Java, haz clic con el botón derecho y selecciona New > Java Class.
Escribe un nombre para el archivo y haz clic en OK.
También asegúrate de especificar las dependencias de bibliotecas de pruebas en el archivo build.gradle del módulo de tu app:


dependencies {
    // Required for local unit tests (JUnit 4 framework)
    testImplementation 'junit:junit:4.12'

    // Required for instrumented tests
    androidTestImplementation 'com.android.support:support-annotations:24.0.0'
    androidTestImplementation 'com.android.support.test:runner:0.5'
}
A fin de obtener dependencias de bibliotecas opcionales y más información para escribir tus pruebas, consulta Cómo crear pruebas de unidades locales y Cómo crear pruebas de unidades instrumentadas.


## Construido con 🛠️

* [Gradle](https://gradle.org/) - Manejador de dependencias
* [retrofit](https://square.github.io/retrofit/) - A type-safe HTTP client for Android and Java
* [Picasso](https://square.github.io/picasso/) - A powerful image downloading and caching library for Android


## Autores ✒️

* **Michael Mejia** - *Trabajo Inicial* - [MikeMC777](https://github.com/MikeMC777)
* **Michael Mejia** - *Documentación* - [MikeMC777](https://github.com/MikeMC777)


## Licencia 📄

Este proyecto está bajo la Licencia de Código abiero - mira el archivo [LICENSE.md](LICENSE.md) para detalles

## Expresiones de Gratitud 🎁

* Comenta a otros sobre este proyecto 📢
* Invita una cerveza 🍺 o un café ☕ a alguien del equipo. 
* Da las gracias públicamente 🤓.
* etc.



---
⌨️ con ❤️ por [MikeMC777](https://github.com/MikeMC777) 😊
 
