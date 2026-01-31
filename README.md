📡 Tecnounautas — Monitoramento e Análise de Tendências em Inteligência Artificial

A ideia inicial do projeto surgiu a partir da criação de um portal agregador de notícias sobre Inteligência Artificial, com o objetivo de identificar e acompanhar tendências do mercado. No entanto, após a definição da estrutura inicial, foi realizada uma revisão de escopo visando maximizar o valor entregue pelo sistema.

Em vez de desenvolver uma aplicação full-stack com foco em apresentação visual, optou-se por concentrar esforços no que atualmente representa o recurso mais valioso no contexto tecnológico: informação estruturada.

Dessa forma, o projeto passou a ter como objetivo a coleta e análise de termos recorrentes em notícias relacionadas à IA, apresentando esses dados por meio de dashboards interativos desenvolvidos no Power BI.

🎯 Objetivo do Projeto

O principal problema resolvido pelo Tecnounautas é a economia de tempo na análise de tendências tecnológicas.
O usuário não precisa mais consumir manualmente grandes volumes de notícias para identificar movimentos relevantes do mercado, pois consegue visualizar rapidamente os temas mais discutidos por meio de dados consolidados e visualizações claras.

📊 Estratégia de Dados

Uma decisão central do projeto foi não armazenar o conteúdo completo das notícias. Textos integrais geralmente são compostos por grandes volumes de strings com baixo valor analítico para o objetivo proposto, além de aumentarem custos de armazenamento e processamento.

Em vez disso, o sistema registra apenas ocorrências de palavras-chave relevantes, permitindo:

redução significativa de custos computacionais

maior eficiência na análise

foco direto em sinais de mercado, e não em ruído informacional

🏗️ Arquitetura e Tecnologias

A aplicação foi desenvolvida utilizando Spring Boot com Maven, escolha motivada pela robustez do framework e pela familiaridade prévia com a linguagem Java em projetos acadêmicos.

A execução automatizada do sistema é realizada por meio do recurso @Scheduled, permitindo a coleta contínua de dados em janelas de tempo predefinidas, operando 24/7 com baixo consumo de recursos.

O banco de dados utilizado é o PostgreSQL, hospedado em ambiente cloud na plataforma Railway. Embora o sistema tenha sido testado localmente, a execução contínua em ambiente local mostrou-se inviável devido a limitações de hardware, reforçando a necessidade de uma solução em nuvem com custo reduzido e alta disponibilidade.

🤖 Uso de IA no Desenvolvimento

Durante o desenvolvimento, foi utilizado o ChatGPT como ferramenta de apoio, guiado por prompts bem definidos que especificavam claramente:

o escopo do projeto

as tecnologias adotadas

as limitações técnicas e conceituais

Essa abordagem permitiu acelerar o desenvolvimento sem comprometer a coerência da solução, evitando sugestões desalinhadas com a proposta original.

⚠️ Desafios Encontrados

Os principais desafios do projeto estiveram relacionados ao tratamento de dados externos, especialmente:

integração com múltiplos feeds RSS

padronização e manipulação das informações coletadas

Além disso, por se tratar do primeiro projeto utilizando Spring Boot em produção, diversos conceitos foram aprendidos por meio de experimentação prática, como a configuração e o ajuste de tarefas agendadas via cron.

🚀 Próximos Passos

Os próximos passos do Tecnounautas incluem:

ampliação do conjunto de palavras-chave monitoradas

análise aprofundada dos primeiros dados coletados

incorporação futura de técnicas de IA para sugerir automaticamente novos termos relevantes, com base no comportamento recorrente do mercado

📌 Consideração final

O Tecnounautas foi concebido desde o início com foco em eficiência, baixo custo e valor estratégico da informação, priorizando dados acionáveis em vez de volume bruto.
