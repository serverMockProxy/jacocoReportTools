import request from '@/utils/request'

export function saveOrUpdate(data) {
  return request({
    method: 'post',
    url: '/requestInfo/saveOrUpdate',
    data
  })
}

export function getRequestInfoList(params) {
  return request({
    method: 'post',
    url: '/requestInfo/list',
    params
  })
}

export function deleteRequestInfo(apiinfoId) {
  return request({
    method: 'delete',
    url: `/requestInfo/${apiinfoId}`
  })
}
