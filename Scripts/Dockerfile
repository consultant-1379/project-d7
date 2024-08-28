FROM debian:11
ADD *.py .
ADD requirements.txt .
RUN set -xe && \
    apt update && \
    apt install -y git && \
    apt install -y python3-pip
RUN pip install --upgrade pip
RUN pip install -r ./requirements.txt
CMD ["python3", "util.py"]