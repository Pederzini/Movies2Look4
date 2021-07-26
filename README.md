# Movies 2Look4
Repositório criado para desenvolvimento do desafio de consumir endpoints da TMDb API. O objetivo deste projeto foi consolidar, em uma aplicação simples, os conceitos de desenvolvimento Android com Kotlin que aprendi através da realização de cursos. A proposta do aplicativo é retornar a lista dos 20 primeiros filmes mais bem votados do site TMDb. Abaixo, segue uma demonstração de seu funcionamento:

![demo](https://user-images.githubusercontent.com/70399469/127043872-3f18a168-9c2d-4216-ad12-7c70016f52bd.gif)

# Tecnologias utilizadas
Abaixo são listadas as principais tecnologias e bibliotecas utilizadas para o desenvolvimento deste projeto:

### Networking
- Retrofit
- RxJava 2
- Gson
- Glide

### Views
- Activity
- Synthetic 
- RecyclerView
- ViewHolder

### Arquitetura*
- MVP
- MVVM (branch 'mvvm')

### Testes unitários
- Mockito e JUnit

### Injeção de dependências*
- Dagger 2
- Koin (branch 'mvvm')

\* O projeto foi desenvolvido, inicialmente, seguindo a arquitetura MVP e com injeção de dependências utilizando Dagger 2. Posteriormente, em outra branch ('mvvm'), foi feita a refatoração do código para se adequadar à arquitetura MVVM e adotando injeção de dependências via Koin.
