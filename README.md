# Movies 2Look4
Repositório criado para desenvolvimento do desafio de consumir endpoints da TMDb API. O objetivo deste projeto foi consolidar, em uma aplicação simples, os conceitos de desenvolvimento Android com Kotlin que aprendi através da realização de cursos. A proposta do aplicativo é retornar a lista dos 20 primeiros filmes mais bem votados do site TMDb. Abaixo, segue uma demonstração de seu funcionamento:

![demo](https://user-images.githubusercontent.com/70399469/127043562-5b16a00f-3a52-4dc0-9cfe-86e11ca3aa10.gif)

# Tecnologias utilizadas
Abaixo são listadas as principais tecnologias e bibliotecas utilizadas para o desenvolvimento deste projeto:

### Networking
- Retrofit
- RxJava 2
- Gson
- Glide
- Coroutines

### UI
- Activity
- Synthetic 
- RecyclerView
- ViewHolder
- ConstraintLayout e LinearLayout
- ViewFlipper

### Arquitetura*
- MVP
- MVVM (branch 'mvvm')

### Testes unitários
- Mockito e JUnit

### Injeção de dependências*
- Dagger 2
- Koin (branch 'mvvm')

\* O projeto foi desenvolvido, inicialmente, seguindo a arquitetura MVP e com injeção de dependências utilizando Dagger 2. Posteriormente, em outra branch ('mvvm'), foi feita a refatoração do código para se adequar à arquitetura MVVM e adotando injeção de dependências via Koin.
