def listarIDs(response):
    ids = ''
    for id in response.json():
        ids = ids + str(id['id']) + ', '
    ids = ids[:-2]
    return ids