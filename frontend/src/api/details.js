import request from '@/utils/request'


export function deleteDetail(data) {
  return request({
    method: 'post',
    url: `/details/delete`,
    data
  })
}

export function getDetailsList(params) {
  return request({
    method: 'post',
    url: '/details/list',
    params
  })
}

