# Proyecto Zoológico

Este proyecto de zoologico fue desarrollado como parte de un trabajo práctico para la materia de Programación Orientada a Objetos II en la Universidad Nacional de La Matanza. El mismo, simula el funcionamiento de un zoológico, permitiendo a los usuarios gestionar animales, cuidadores, jaulas, hábitats y visitantes.

## Características Principales
- Utilización de herencia para modelar las relaciones entre las diferentes clases de animales y personas en el zoológico.
- Implementación de polimorfismo para permitir comportamientos específicos en las subclases de la clase `Animal`.
- Uso de clases abstractas para definir comportamientos generales en la clase `Animal`.
- Implementación de interfaces como `Acuario` para definir contratos comunes entre las clases que representan diferentes áreas del zoológico.
- Empleo de colecciones como `List` y `Set` para almacenar y gestionar conjuntos de animales y personas de manera eficiente.
- Implementación de los métodos `hashCode` y `equals` para garantizar la correcta identificación y comparación de objetos en colecciones basadas en hash.

### Funcionalidades principales
Gestión de animales: Los usuarios pueden agregar, eliminar y administrar animales en el zoológico, incluyendo diferentes especies como leones, delfines, loros, elefantes, entre otros.

Gestión de jaulas y hábitats: El sistema permite crear y administrar jaulas para alojar a los animales, así como hábitats para aquellos animales que requieren un entorno específico.

Gestión de cuidadores: Los cuidadores son responsables de alimentar y cuidar a los animales. El sistema permite asignar cuidadores a jaulas y realizar tareas de alimentación.

Gestión de visitantes: Los usuarios pueden registrar visitantes, vender entradas y gestionar la entrada de los visitantes a áreas específicas del zoológico, como el acuario o espectáculos de animales.

### Estructura del proyecto
El proyecto está organizado en varios paquetes y clases:

ar.edu.unlam.pb2.zoologico: Contiene las clases principales del proyecto, incluyendo las definiciones de animales, personas (como visitantes y cuidadores), jaulas, hábitats, tipos de entrada, entre otros.

ar.edu.unlam.pb2.test: Contiene los casos de prueba JUnit para probar las funcionalidades del proyecto.

### Autores
Este proyecto fue desarrollado por:
- [Greatti Gonzalo Nahuel](https://github.com/gonzamirko)
- [Menicucci Giuliana](https://github.com/gmenii)
- [Mutuverría Martín](https://github.com/ma3rtin)
- [Ricartes Pedro](https://github.com/ricartes123)


