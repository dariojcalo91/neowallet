# 🚀 NeoWallet: Distributed Fintech Engine

[![Java 21](https://img.shields.io/badge/Java-21-orange?logo=openjdk)](https://openjdk.org/projects/jdk/21/)
[![Spring Boot 3.2](https://img.shields.io/badge/Spring_Boot-3.2-brightgreen?logo=springboot)](https://spring.io/projects/spring-boot)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

[![NeoWallet CI Pipeline](https://github.com/dariojcalo91/neowallet/actions/workflows/ci.yml/badge.svg)](https://github.com/dariojcalo91/neowallet/actions)

Sistema de billetera digital distribuida diseñado bajo principios de **Domain-Driven Design (DDD)**, **Arquitectura Hexagonal** y **TDD**.

## 🏗️ Arquitectura
El proyecto utiliza una arquitectura de microservicios con comunicación asíncrona:
- **Account Service:** Gestión de saldos y usuarios.
- **Transaction Service:** Registro y validación de movimientos.
- **Common Lib:** Librería compartida para estandarización de respuestas.

## 🛠️ Stack Tecnológico
- **Lenguaje:** Java 21 (LTS)
- **Framework:** Spring Boot 3.2.x
- **Mensajería:** Apache Kafka
- **Base de Datos:** PostgreSQL
- **Infraestructura:** Docker & Docker Compose
- **CI/CD:** GitHub Actions

## 🚦 Roadmap de Desarrollo
- [x] Estructura Multi-módulo de Maven.
- [x] Modelado de Dominio (Account Entity) con TDD.
- [ ] Implementación de Persistencia (Spring Data JPA).
- [ ] Integración con Kafka para eventos de transacción.
- [ ] API Gateway y Discovery Server.
