import request from '@/utils/request'

export function getBranches(projectId) {
  return request({
    method: 'get',
    url: `/jacoco/getBranches/${projectId}`
  })
}

export function getCommits(projectId,params) {
  return request({
    method: 'get',
    url: `/jacoco/getCommits/${projectId}`,
    params
  })
}

export function creatReport(data) {
  return request({
    method: 'post',
    url: `/jacoco/creatReport`,
    data
  })
}

export function getjacocoList(params) {
  return request({
    method: 'post',
    url: '/jacoco/list',
    params
  })
}

export function deleteJacocos(data) {
  return request({
    method: 'post',
    url: `/jacoco/delete`,
    data
  })
}
