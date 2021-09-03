import request from '@/utils/request'

export function query(data) {
  return request({
    method: 'post',
    url: '/tools/query',
    data
  })
}
