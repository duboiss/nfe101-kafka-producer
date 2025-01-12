# OpenRefine
Suppression de colonnes :
- uid_adresse : vide pour tous
- commune_insee : code postal "87085" pour tous
- lieudit_complement_nom : vide pour tous
- commune_nom : "Limoges" pour tous
- commune_deleguee_insee : vide pour tous
- commune_deleguee_nom : vide pour tous
- source : "ville de limoges" pour tous
- certification-commune : "1" pour tous
- date_der_maj : "2024-12-22" pour tous

Suppression de trois éléments qui n'ont rien à faire, ayant comme "position" :
- "entrée" (2 records)
- "service technique" (1 record)
-> Suppression de la colonne "position" qui contient "délivrance postale" pour tous

Numéro : nombre
Tri par voie_nom, puis tri par numero

Suppression de 3 duplicats cle_interop (customized facet "duplicates facet")

# Kafka
## Configuration
```sh
KAFKA_CLUSTER_ID="$(bin/kafka-storage.sh random-uuid)"
bin/kafka-storage.sh format --standalone -t $KAFKA_CLUSTER_ID -c config/kraft/reconfig-server.properties
bin/kafka-server-start.sh config/kraft/reconfig-server.properties
````

## Commandes
### Créer un topic
bin/kafka-topics.sh --create --topic greeting-nfe101 --bootstrap-server localhost:9092 --partitions 3
bin/kafka-topics.sh --create --topic test --bootstrap-server localhost:9092 --partitions 3
bin/kafka-topics.sh --create --topic addresses --bootstrap-server localhost:9092 --partitions 3

### Lister les topics
bin/kafka-topics.sh --bootstrap-server localhost:9092 --list

### Description / configuration d'un topic
bin/kafka-topics.sh --describe --topic greeting-nfe101 --bootstrap-server localhost:9092

### CLI producer
bin/kafka-console-producer.sh --topic greeting-nfe101 --bootstrap-server localhost:9092

### CLI consumer
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic greeting-nfe101 --from-beginning
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic addresses --from-beginning
