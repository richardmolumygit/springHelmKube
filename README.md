# Rich Molumb 09/18/2026
# Spring boot web app
# Added help chart
# Added DockerFile
# Added Helm chart

## Deploy to kind

Create the cluster with the NodePort mapped to the host:

```bash
kind create cluster --config kind-rich-cluster.yaml
```

Build and load the image, then deploy the chart:

```bash
docker build -t rich-demo:local .
kind load docker-image rich-demo:local --name rich-cluster
kubectl config use-context kind-rich-cluster
helm upgrade --install rich-demo ./helm/rich-demo --namespace dev --create-namespace --wait
```

The application is available at http://localhost:30090/ without port-forwarding.
