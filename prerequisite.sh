#!/bin/bash
echo "Knative Serving start"
  kubectl apply -f https://github.com/knative/serving/releases/download/knative-v1.8.3/serving-crds.yaml
  kubectl apply -f https://github.com/knative/serving/releases/download/knative-v1.8.3/serving-core.yaml
  kubectl apply -f https://github.com/knative/net-kourier/releases/download/knative-v1.8.1/kourier.yaml
  kubectl patch configmap/config-network \
  --namespace knative-serving \
  --type merge \
  --patch '{"data":{"ingress-class":"kourier.ingress.networking.knative.dev"}}'
  kubectl --namespace kourier-system get service kourier
  kubectl get pods -n knative-serving

echo "Knative Serving end"
echo "Tekton start"
kubectl apply --filename https://storage.googleapis.com/tekton-releases/pipeline/latest/release.yaml
kubectl apply --filename https://storage.googleapis.com/tekton-releases/dashboard/latest/tekton-dashboard-release.yaml
kubectl --namespace tekton-pipelines port-forward svc/tekton-dashboard 9097:9097
kubectl apply -f https://raw.githubusercontent.com/tektoncd/catalog/master/task/git-clone/0.6/git-clone.yaml
kubectl apply -f https://raw.githubusercontent.com/tektoncd/catalog/master/task/buildpacks/0.3/buildpacks.yaml
kubectl apply -f https://raw.githubusercontent.com/tektoncd/catalog/main/task/kubernetes-actions/0.2/kubernetes-actions.yaml
echo "Tekton end"
