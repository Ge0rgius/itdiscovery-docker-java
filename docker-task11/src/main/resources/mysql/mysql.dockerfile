FROM mysql:8

#ENV MYSQL_ROOT_PASSWORD=root \
#    MYSQL_DATABASE=discovery

COPY createdb.sql /docker-entrypoint-initdb.d/

#HEALTHCHECK --interval=1m CMD mysql -uroot -p${MYSQL_ROOT_PASSWORD} -e "SHOW DATABASES;"



