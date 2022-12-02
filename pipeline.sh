#!/bin/bash
echo "Pipeline install start"
kubectl apply -f tekton/configmap.yaml
kubectl apply -f tekton/resource.yaml
kubectl apply -f tekton/service-account.yaml
kubectl apply -f tekton/tekton-pipeline.yaml
kubectl apply -f tekton/tekton-pipelinerun.yaml
echo "Pipeline install end"
