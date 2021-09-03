import request from '@/utils/request'

export function creatOrUpdate(data) {
  return request({
    method: 'post',
    url: `/jacocoConfig/creatOrUpdate`,
    data
  })
}

export function getJacocoConfig(id) {
  return request({
    method: 'get',
    url: `/jacocoConfig/getConfig/${id}`
  })
}
