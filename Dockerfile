FROM gradle:7.5.1-jdk17
WORKDIR /app
ADD build.gradle.kts /app/
RUN gradle build -x test --parallel --continue > /dev/null 2>&1 || true

COPY . /app
RUN gradle clean build --no-daemon
CMD java -jar build/libs/*.jar