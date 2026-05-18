# API REST - Gestor de Torneos E-Sports 🎮

Este proyecto es la **API 2 (Adicional)** desarrollada para cumplir con la "Condición Especial" del Trabajo Práctico. Implementa un sistema de gestión para ligas de E-Sports, cumpliendo con los mismos estándares de arquitectura, seguridad y testing que la API principal.

## 🚀 Tecnologías Utilizadas

* **Java 17**
* **Spring Boot** (Web, Data JPA, Validation)
* **Spring Security & JWT** (Autenticación y protección de endpoints)
* **MySQL** (Base de datos relacional)
* **Lombok** (Reducción de boilerplate)
* **JUnit 5 & Mockito** (Testing unitario)

## 🏗️ Arquitectura y Entidades

El proyecto sigue un diseño por capas (Controller, Service, Repository) utilizando DTOs con validaciones (`@NotBlank`, `@NotNull`) para el intercambio de datos. Se implementaron las siguientes entidades y relaciones:

* **Manager:** Administrador del sistema. Tiene una relación `OneToMany` con sus equipos.
* **Equipo:** Entidad principal del CRUD. Tiene una relación `ManyToOne` con Manager y `ManyToMany` con Torneo.
* **Torneo:** Competencia que agrupa a varios equipos (`ManyToMany`).

## 🔐 Seguridad (JWT)

A pesar de ser la API secundaria, se implementó un flujo completo de seguridad para cumplir con los requisitos extendidos:
* Endpoint `/api/auth/login` público para autenticación.
* Resto de la API protegida mediante `Bearer Token`.
* Filtros personalizados y UserDetailsService adaptado a la entidad `Manager`.

## 🧪 Testing

* Pruebas unitarias implementadas para la capa de servicios (`EquipoService`).
* Uso de mocks (`@Mock`, `@InjectMocks`) para simular la base de datos y verificar la correcta ejecución de las reglas de negocio, logrando aserciones exitosas.