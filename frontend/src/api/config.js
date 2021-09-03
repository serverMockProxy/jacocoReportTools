import request from '@/utils/request'

export function addConfig(data) {
  return request({
    method: 'post',
    url: '/config/add',
    data
  })
}

export function deleteConfig(id) {
  return request({
    method: 'delete',
    url: `/config/${id}`
  })
}

export function updateConfig(data) {
  return request({
    method: 'post',
    url: '/config/update',
    data
  })
}

export function getConfigList(params) {
  return request({
    method: 'post',
    url: '/config/list',
    params
  })
}

export function importJson(data) {
  return request({
    method: 'post',
    url: `/config/importJson`,
    data
  })
}
